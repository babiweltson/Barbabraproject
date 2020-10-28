package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.Event;
import com.hellosign.sdk.resource.SignatureRequest;
import com.hellosign.sdk.resource.support.CustomField;


@WebServlet("/CallbackServlet")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = "/tmp"
)
public class CallbackServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
    	
		
		StringBuilder sb = new StringBuilder();
		InputStream ios = req.getPart("json").getInputStream();
		int i;
		while ((i = ios.read()) != -1) {
			sb.append((char) i);
		}
		ios.close();
		
    	String jsonStr = sb.toString();
    	
        // Convert the JSON string to a JSONObject
        JSONObject json = null;
        try {
            json = new JSONObject(jsonStr);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    	
        
     
    	
        try {
            Event event = new Event(json);
            
            for(CustomField field : event.getSignatureRequest().getCustomFields()) {
            	if (field.getName().equalsIgnoreCase("Percentage")){
            		System.out.println(field.getValue());
            	}
            	
            }
            
            for (int index=0;i< json.length();i++) {
            	System.out.println(json.getJSONArray("created_at"));
            	
            }
            	
            	
            
            
            //json.
            
            System.out.println(event.toString());
            if (event.isValid("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6")) {
                System.out.println("Event received:");
                if (event.hasAccountId()) {
                    System.out.println("\tAccount ID: " + event.getAccountId());
                }
                DateFormat dateformat = DateFormat.getDateTimeInstance();
                dateformat.setTimeZone(TimeZone.getTimeZone("US/Pacific"));
                System.out.println("\tDate: " + dateformat.format(event.getEventDate()));
                System.out.println("\tType: " + event.getType());
                if (event.hasSignatureRequest()) {
                    System.out.println("\tSignature Request: " + event.getSignatureRequest().getId());
                    
                }
                if (event.hasRelatedSignatureId()) {
                    System.out.println("\tSignature ID: " + event.getRelatedSignatureId());
                }
                

            }
        } catch (HelloSignException ex) {
            ex.printStackTrace();
        }

        
        // Respond to HelloSign with an HTTP 200 and valid message
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Hello API Event Received");
	}

}

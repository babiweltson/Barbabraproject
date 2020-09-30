package com.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.DateFormat;
import java.util.TimeZone;
import java.util.logging.Handler;
import org.json.JSONException;
import org.json.JSONObject;

import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.Event;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class JavaHTTPServer {
	
	private static final String apiKey = "";

	   public static void main(String[] args) throws Exception {

		  
		   HttpServer server  = HttpServer.create(new InetSocketAddress("localhost", 8002), 0);
	        server.createContext("/test", new MyHandler());
	        server.setExecutor(null); // creates a default executor
	        server.start();
	    }

	    static class MyHandler implements HttpHandler {
	        public void handle(HttpExchange t) throws IOException {
	            String response = "This is the response";
	            t.sendResponseHeaders(200, response.length());
	            OutputStream os = t.getResponseBody();
	            os.write(response.getBytes());
	            os.close();
	        }
	        
	        
	     
	       

	        JSONObject json = null;
	  
	     try {   
            Event event = new Event(json);
     
            
            if (event.isValid(apiKey)) {
            	System.out.print("Event received:");
                if (event.hasAccountId()) {
                	System.out.print("\tAccount ID: " + event.getAccountId());
                }
                DateFormat dateformat = DateFormat.getDateTimeInstance();
                dateformat.setTimeZone(TimeZone.getTimeZone("US/Pacific"));
                System.out.print("\tDate: " + dateformat.format(event.getEventDate()));
                System.out.print("\tType: " + event.getType());
                if (event.hasSignatureRequest()) {
                	System.out.print("\tSignature Request: " + event.getSignatureRequest().getId());
                }
                if (event.hasRelatedSignatureId()) {
                    System.out.print("\tSignature ID: " + event.getRelatedSignatureId());
                }
            }
         }catch  (HelloSignException ex) {
                ex.printStackTrace();
            
            }
            

        // Respond to HelloSign with an HTTP 200 and valid message
 

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Hello API Event Received");
    }
	}

}

	   


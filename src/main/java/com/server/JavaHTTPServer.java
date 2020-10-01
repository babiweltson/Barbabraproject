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
	
	private static final String apiKey = "c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6";
	private static final String client_id = "e32a44e8f4f09361a9a73586e3811c1a";
	public static final JSONObject json = null;

	   public static void main(String[] args) throws Exception {

		  
		   HttpServer server  = HttpServer.create(new InetSocketAddress("localhost", 8003), 0);
	        server.createContext("/", new MyHandler());
	        server.start();
	        //server.stop(0);
	        //httpThreadPool.shutdown(); 
	       
	    }

	    static class MyHandler implements HttpHandler {
	        
			public void handle(HttpExchange t) throws IOException {
				
		         t.getResponseHeaders().set("Content-Type", "text/plain");
		         String response = "Hello API Event Received";
		         t.sendResponseHeaders(200, response.length());
		         OutputStream os = t.getResponseBody();
		         os.write(response.getBytes());
		         os.flush();
		         os.close();
	         

	       
	  
	 
//			
//		        
//            Event event = null;
//			try {
//				event = new Event(json);
//			} catch (HelloSignException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				
//			}
//     
//            
//            try {
//				if (event.isValid(apiKey)) {
//					System.out.print("Event received:");
//				    if (event.hasAccountId()) {
//				    	System.out.print("\tAccount ID: " + event.getAccountId());
//				    }
//				    DateFormat dateformat = DateFormat.getDateTimeInstance();
//				    dateformat.setTimeZone(TimeZone.getTimeZone("US/Pacific"));
//				    System.out.print("\tDate: " + dateformat.format(event.getEventDate()));
//				    System.out.print("\tType: " + event.getType());
//				    if (event.hasSignatureRequest()) {
//				    	System.out.print("\tSignature Request: " + event.getSignatureRequest().getId());
//				    }
//				    if (event.hasRelatedSignatureId()) {
//				        System.out.print("\tSignature ID: " + event.getRelatedSignatureId());
//				    }
//				}
//			}catch (HelloSignException e) {
//				// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//        
	    }
	  
	  }
   
}

	   


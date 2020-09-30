//package com.server;
//
//
//import java.io.IOException;
//import java.text.DateFormat;
//import java.util.Enumeration;
//import java.util.List;
//import java.util.TimeZone;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//import com.hellosign.sdk.HelloSignException;
//import com.hellosign.sdk.resource.Event;
//
//
//
//public class ExampleCallbackServlet extends JavaHTTPServer {
//
//	 private static final Logger logger = LoggerFactory.getLogger(ExampleCallbackServlet.class);
//
//	    private static final long serialVersionUID = -5673774222721758983L;
//	    private static final String API_KEY_INIT_PARAM = "hellosign.api.key";
//
//	    private String apiKey;
//
//	    public ExampleCallbackServlet() {
//	        apiKey = System.getProperty(API_KEY_INIT_PARAM);
//	    }
//
//	    @Override
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//	        Enumeration<String> names = request.getParameterNames();
//	        while (names.hasMoreElements()) {
//	            String name = names.nextElement();
//	            System.out.println(name + " = " + request.getParameter(name));
//	        }
//	        // First, process the response body and retrieve the JSON object
//	        // (it lives in the POST field called "json")
//	        String jsonStr = null;
//	        try {
//	            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//	            for (FileItem item : items) {
//	                if ("json".equals(item.getFieldName())) {
//	                    jsonStr = item.getString();
//	                }
//	            }
//	        } catch (FileUploadException ex) {
//	            ex.printStackTrace();
//	        }
//	        if (jsonStr == null) {
//	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	            return;
//	        }
//
//	        // Convert the JSON string to a JSONObject
//	        JSONObject json = null;
//	        try {
//	            json = new JSONObject(jsonStr);
//	        } catch (JSONException ex) {
//	            ex.printStackTrace();
//	        }
//	        if (json == null) {
//	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	            return;
//	        }
//
//	        // Create a new Event so we can work with the response
//	        try {
//	            Event event = new Event(json);
//	            logger.debug(event.toString());
//	            if (event.isValid(apiKey)) {
//	                logger.debug("Event received:");
//	                if (event.hasAccountId()) {
//	                    logger.debug("\tAccount ID: " + event.getAccountId());
//	                }
//	                DateFormat dateformat = DateFormat.getDateTimeInstance();
//	                dateformat.setTimeZone(TimeZone.getTimeZone("US/Pacific"));
//	                logger.debug("\tDate: " + dateformat.format(event.getEventDate()));
//	                logger.debug("\tType: " + event.getType());
//	                if (event.hasSignatureRequest()) {
//	                    logger.debug("\tSignature Request: " + event.getSignatureRequest().getId());
//	                }
//	                if (event.hasRelatedSignatureId()) {
//	                    logger.debug("\tSignature ID: " + event.getRelatedSignatureId());
//	                }
//	            }
//	        } catch (HelloSignException ex) {
//	            ex.printStackTrace();
//	        }
//
//	        // Respond to HelloSign with an HTTP 200 and valid message
//	        response.setContentType("text/plain");
//	        response.setStatus(HttpServletResponse.SC_OK);
//	        response.getWriter().println("Hello API Event Received");
//	    }
//	}
//}

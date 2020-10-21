package com.barbara;

import java.io.File;

import org.json.JSONObject;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.SignatureRequest;
import com.hellosign.sdk.resource.TemplateSignatureRequest;

public class SendWithTemplate {

	public static void main(String[] args) throws HelloSignException {
		TemplateSignatureRequest request = new TemplateSignatureRequest();
		request.setTemplateId("5832da31c470f266a57cf50ac5a62760b96da338");
		request.setSubject("Purchase Order-3");
		request.setMessage("Glad we could come to an agreement.");
		request.setSigner("Client", "bweltson@dropbox.com", "Barbara");
		request.setSigner("Manager", "bweltson+1@dropbox.com", "Barbara 2");
		request.setCC("Accounting", "bweltson@hellosign.com");
		request.setCustomFieldValue("Cost", "$20,000");
		request.setCustomFieldValue("Currency", "Euro");
		request.setCustomFieldValue("Percentage", "3%");
		request.setRedirectUrl("http://www.google.com");
		request.addFile(new File("/Users/bweltson/Documents/Template Signature.docx"));
		
		

		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
	
			SignatureRequest newRequest = client.sendTemplateSignatureRequest(request);
			

			
		
		

	}

}

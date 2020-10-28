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
		request.setTemplateId("0bb2f2aabd5000b7a6a695a0770eed363213314e");
		request.setSubject("Test merge fields duplicated");
		//request.setMessage("Glad we could come to an agreement.");
		request.setSigner("1", "bweltson@dropbox.com", "Barbara");
		//request.setCC("Accounting", "bweltson@hellosign.com");
		request.setCustomFieldValue("same", "12/03/2030");
		//request.setRedirectUrl("http://www.google.com");
		//request.addFile(new File("/Users/bweltson/Documents/Template Signature.docx"));
		
		

		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
	
			SignatureRequest newRequest = client.sendTemplateSignatureRequest(request);
			

			
		
		

	}

}

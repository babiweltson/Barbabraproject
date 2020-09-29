package com.barbara;

import org.json.JSONObject;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.EmbeddedRequest;
import com.hellosign.sdk.resource.SignatureRequest;
import com.hellosign.sdk.resource.TemplateSignatureRequest;

public class SendEmbeddedWithTemplate {
	
	public static void main(String[] args) throws HelloSignException {
		
		TemplateSignatureRequest request = new TemplateSignatureRequest();
		request.setTemplateId("8003e4122c4dcbea4f933f7a4cd1bbb9da83a3ba");
		request.setSubject("Hello Test");
		request.setMessage("Please sign this ASAP");
		request.setSigner("Client", "bweltson@hellosign.com", "Babs");
		request.setTestMode(true);
		
		

		String clientId = "e32a44e8f4f09361a9a73586e3811c1a";
		EmbeddedRequest embedReq = new EmbeddedRequest(clientId, request);

		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		SignatureRequest newRequest = (SignatureRequest) client.createEmbeddedRequest(embedReq);
		

		for(Object signature : newRequest.getJSONObject().getJSONArray("signatures") ) {    
			SendEmbeddedSignatureRequest.signatureId = ((JSONObject) signature).getString("signature_id");
			}
		
			
			System.out.println(SendEmbeddedSignatureRequest.signatureId);
			
	}


	
		

}



package com.barbara;

import java.io.File;

import org.json.JSONObject;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.EmbeddedRequest;
import com.hellosign.sdk.resource.EmbeddedResponse;
import com.hellosign.sdk.resource.SignatureRequest;

public class SendEmbeddedSignatureRequest {

	public static void main(String[] args) throws HelloSignException {
		SignatureRequest request = new SignatureRequest();
		
		request.setTitle("Test Babs");
		request.setSubject("The NDA we talked about");
		request.setMessage("Let me know if you have any questions.");
		request.addSigner("bweltson@hellosign.com", "Barbara 1");
		request.addSigner("bweltson@dropbox.com", "Babs");
		request.addCC("bweltson+1@hellosign.com");;
		request.addFile(new File("/Users/bweltson/Documents/Template Signature.docx"));
		request.setTestMode(true);

		String clientId = "e32a44e8f4f09361a9a73586e3811c1a";
		EmbeddedRequest embedReq = new EmbeddedRequest(clientId, request);

		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		SignatureRequest newRequest = (SignatureRequest) client.createEmbeddedRequest(embedReq);
		
		System.out.println(newRequest.getSignature("bweltson@hellosign.com", "Barbara 1").getId());
		
		System.out.println(newRequest.getJSONObject());
		
	
	}
	

}


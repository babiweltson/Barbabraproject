package com.barbara;

import java.io.File;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.SignatureRequest;
import com.hellosign.sdk.resource.support.Document;
import com.hellosign.sdk.resource.support.FormField;
import com.hellosign.sdk.resource.support.types.FieldType;
import com.hellosign.sdk.resource.support.types.ValidationType;

public class SendSignatureRequest {

	public static void main(String[] args) throws HelloSignException {
		SignatureRequest request = new SignatureRequest();
		Document doc1 = new Document();
		Document doc2 = new Document();
		request.setTitle("Playing with the API");
		request.setSubject("Playing with the API");
		request.addSigner("bweltson@hellosign.com", "Babs");
		doc1.setFile(new File("/Users/bweltson/Documents/Test Box.pdf"));
		doc2.setFile(new File("/Users/bweltson/Documents/Basic-Non-Disclosure-Agreement.pdf"));
		request.setIsDeclinable(false);
		request.setRedirectUrl("https://www.google.com/");
		
		
		FormField textField = new FormField();
		textField.setType(FieldType.TEXT);
		textField.setApiId("test form fields");
		textField.setName("test");
		textField.setSigner(0); 
		textField.setHeight(25);
		textField.setWidth(30);
		textField.setIsRequired(true);
		textField.setPage(1); // 
		textField.setX(80);
		textField.setY(80);
		textField.setValidationType(ValidationType.letters_only);
		

		FormField dateField = new FormField();
		dateField.setType(FieldType.DATE_SIGNED);
		dateField.setApiId("test date form fields");
		dateField.setName("date form fields");
		dateField.setSigner(0); 
		dateField.setHeight(35);
		dateField.setWidth(40);
		dateField.setIsRequired(true);
		dateField.setPage(1); 
		dateField.setX(100);
		dateField.setY(100);
		
		
		
		doc1.addFormField(textField);
		doc1.addFormField(dateField);
		request.addDocument(doc1);
		request.addDocument(doc2);

		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		SignatureRequest newRequest = client.sendSignatureRequest(request);
		
	}

}

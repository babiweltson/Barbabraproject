package com.barbara;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;

public class SendReminderSignatureRequest {

	public static void main(String[] args) throws HelloSignException {
		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		String signatureRequestId = "049947daa45e01ae16f0d4da7d11264b5c3bd19f";
		client.requestEmailReminder(signatureRequestId, "bweltson@hellosign.com");
		
	}

}

package com.barbara;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;

public class CancelSignatureRequest {
	public static void main(String[] args) throws HelloSignException {
	
	HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");	
	String signatureRequestId = "94c854f92c4b1396c54150fadec4247d3b455eca";
	client.cancelSignatureRequest(signatureRequestId);

	}
}

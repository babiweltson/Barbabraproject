package com.barbara;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.support.SignatureRequestList;

public class Main {

	public static void main(String[] args) throws HelloSignException {
		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		SignatureRequestList list = client.getSignatureRequests(1); // page 1
		System.out.println(list);
	}

}

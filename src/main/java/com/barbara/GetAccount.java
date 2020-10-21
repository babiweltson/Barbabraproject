package com.barbara;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.Account;

public class GetAccount {

	public static void main(String[] args) throws HelloSignException {
		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		Account account = client.getAccount();
		System.out.println(account);
	}
	

}

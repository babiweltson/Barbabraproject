package com.barbara;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.Template;
import com.hellosign.sdk.resource.TemplateSignatureRequest;

public class GetTemplate {

	public static void main(String[] args) throws HelloSignException {
		HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
		Template template = client.getTemplate("8003e4122c4dcbea4f933f7a4cd1bbb9da83a3ba");
		System.out.println(template);
		
	}

}

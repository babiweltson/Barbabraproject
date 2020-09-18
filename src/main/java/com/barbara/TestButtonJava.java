package com.barbara;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.support.SignatureRequestList;

public class TestButtonJava implements ActionListener { //notice implements ActionListener
	    JButton button;

	    public static void main (String[] args) {
	    	TestButtonJava gui = new TestButtonJava();
	       
	        gui.press();

	    }

	    public void press(){
	        JFrame frame = new JFrame(); //creates a Java Frame called frame
	        button = new JButton("API Signature Request List"); //creates a Button
	        
	        
	        button.addActionListener(this); //listens for button press
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program when JFrame closed

	        frame.getContentPane().add(button); //adds button to frame

	        frame.setSize(800,600); //pixel size of frame in width then height

	        frame.setVisible(true); //if false then frame will be invisible

	    }

	    public void actionPerformed(ActionEvent event){ //if button is pressed then this changes button text
	    	button.setText("Loading...");
	    	
			HelloSignClient client = new HelloSignClient("c15ea3a35f926cc6a0c495e2bc019543e49f9d2f41019adc0f3fbb6909bddfa6");
			SignatureRequestList list;
			try {
				list = client.getSignatureRequests(1);
				
				
				System.out.println(list);
				
				button.setText(list.toString());
			} catch (HelloSignException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // page 1
			
	    }

	}




package com.spring2;

public class EmailService{

	private String emailMessage;
	
	public EmailService(String emailMessage) {
		this.emailMessage=emailMessage;
	}
	
	public void printMessage() {
		System.out.println("This is email Service Message "+emailMessage);
	}
	
}
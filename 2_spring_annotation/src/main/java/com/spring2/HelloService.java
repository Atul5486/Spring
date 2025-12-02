package com.spring2;

public class HelloService{
	
	private String helloMessage;

	public void getHelloMessage() {
		 System.out.println("This is hellomessage "+helloMessage);
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}
	
	
	
}

package com.spring2;

import org.springframework.stereotype.Component;

@Component
public class SMSService{

	public void printMessage() {
		System.out.println("This is sms Message");
	}
}
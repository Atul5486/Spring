package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Primary
public class GmailService implements EmailService{
	
	@Value("${app.gmailEmail}")
	private String message;
	
	public GmailService() {
		System.out.println("Gmail Service constructor called");
	}
	
	@Override
	public void printEmailService() {
		System.out.println("Hello User, Your email id is "+message);
	}
}
package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class Yahoo implements EmailService{
	
	@Value("${app.yahooEmail}")
	String yahooEmail;
	public Yahoo() {
		System.out.println("Yahoo Service Constructor called!!");
	}
	@Override
	public void printEmailService() {
		System.out.println("Hello User, your email id is "+yahooEmail);
	}
}
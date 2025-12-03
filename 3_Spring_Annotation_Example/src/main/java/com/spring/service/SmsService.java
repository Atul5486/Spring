package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Service
//@Scope("singleton")
@Scope("prototype")
public class SmsService{
	
	@Value("${app.number}")
	long number;
	
	public SmsService() {
		System.out.println("Sms Service constructor called");
	}
	
	public void printNumber() {
		System.out.println("Recieved SMS from "+number);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Post constructor called");
	}
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("invoked by spring before termination of bean\"");
	}
}
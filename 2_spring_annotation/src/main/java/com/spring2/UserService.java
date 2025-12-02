package com.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	private EmailService emailService;
	private HelloService helloService;
	
	@Autowired
	private SMSService smsService;
	
	public UserService() {
		System.out.println("this is constructor of User Service");
	}
	
	@Autowired
	public UserService(EmailService emailService){
		this.emailService=emailService;
	}
	
	@Autowired
	public void setHelloService(HelloService helloService) {
		this.helloService=helloService;
	}
	
	public void actionPerfomed() {
		emailService.printMessage();
		helloService.setHelloMessage("this is a mesaage for hello Service");
		helloService.getHelloMessage();
		smsService.printMessage();
	}
	
	
}
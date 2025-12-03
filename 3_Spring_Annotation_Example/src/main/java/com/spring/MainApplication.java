package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.service.EmailService;
import com.spring.service.HelloService;
import com.spring.service.SmsService;

@Component
public class MainApplication{
	private EmailService emailService;
	private SmsService smsService;
	
	@Autowired
	private HelloService helloService;
	
	
	public MainApplication(EmailService emailService) {
		this.emailService=emailService;
	}
	
	@Autowired
	public void setSmsService(SmsService smsService) {
		this.smsService=smsService;
	}
	
	public void actionPerformed() {
		helloService.printHelloService();
		emailService.printEmailService();
	}
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		MainApplication main=context.getBean(MainApplication.class);
		main.actionPerformed();
		
		SmsService sms1=context.getBean(SmsService.class);
		System.out.println(sms1);
		sms1.printNumber();
		
		SmsService sms2=context.getBean(SmsService.class);
		System.out.println(sms2);
		sms2.printNumber();
		
		((AbstractApplicationContext)context).close();
		
	}
}
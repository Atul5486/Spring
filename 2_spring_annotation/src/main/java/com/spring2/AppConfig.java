package com.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring2")
public class AppConfig{
	
	@Bean
	public EmailService emailService() {
		return new EmailService("Hello@gmail.com");
	}
	
	@Bean 
	public HelloService helloService() {
		return new HelloService();
	}
}
package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication{
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Demo1Service demo1=context.getBean(Demo1Service.class);
		
		Demo2Service demo2=context.getBean(Demo2Service.class);
		
		demo1.setMessage("Hello how are you");
		demo1.printMessage();
		System.out.println(demo1.getMessage());
		
		
		demo2.printMessage();
	}
}
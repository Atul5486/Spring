package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication{
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Demo1Service demo1=(Demo1Service)context.getBean("demo1Service");
		System.out.println(demo1.getMessage());
		
		Demo2Service demo2=(Demo2Service)context.getBean("demo2Service");
		demo2.printMessage();
	}
}
package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.AppConfig;
import com.spring.model.User;
import com.spring.service.UserService;

public class Main{
	public static void main(String args[]) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService=context.getBean(UserService.class);
		
//		userService.addUserService(new User("peter@peter.com", "peter123","Indore"));

		User user=userService.getUserByIdService(1);
		
		userService.updateUserService(user);
		try {
			userService.deleteUserService(1);
		}catch(Exception e) {
			System.out.println("Exception during deleting user"+e);
		}
		System.out.println(user);
	}
		
}
package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.AppConfig;
import com.spring.dao.UserDao;
import com.spring.model.User;

public class MainNamed{
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserDao userDao=context.getBean(UserDao.class);
		userDao.addUser(new User(101,"Hello","hello@gmail.com","Indore"));
	}
}
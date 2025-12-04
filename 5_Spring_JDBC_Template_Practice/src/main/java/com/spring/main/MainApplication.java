package com.spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.AppConfig;
import com.spring.dao.UserDao;
import com.spring.model.User;

public class MainApplication{
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserDao userDao= context.getBean(UserDao.class);
//		userDao.addUser(new User(103,"Peterson","peterson@gmail.com","Peterson"));
//		userDao.updateUser(new User(103,"Peter","peter@gmail.com","peter"));
		userDao.deleteUser(101);
		User use=userDao.getUser(102);
		System.out.println("Current User : "+use.getEmail());
		List<User> users= userDao.allUser();
		for(User user:users) {
			System.out.println(user.getUsername());
		}
	}
}
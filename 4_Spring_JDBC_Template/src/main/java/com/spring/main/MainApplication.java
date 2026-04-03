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
		
//		userDao.addUser(new User(101,"Andrew Anderson","andrew@gmail.com","Indore"));
//		userDao.addUser(new User(102,"Peter Parker","peter@gmail.com","Dewas"));
//		userDao.addUser(new User(103,"Jackson Jack","jackson@gmail.com","Ujjain"));
//		userDao.addUser(new User(104,"Mathew Math","mathew@gmail.com","Nagda"));
//		userDao.addUser(new User(105,"Simon Sim","simon@gmail.com","Jabalpur"));
//		System.out.println("\nData inserted successfully");
//		
//		userDao.deleteUser(102);
//		System.out.println("User 102 deleted successfully");
//		
//		userDao.updateUser(new User(101,"Andrew andy","andy@gmail.com","Dewas"));
//		System.out.println("User 101 updated successfully");
		
		List<User> users=userDao.allUser();
		for(User user:users) {
			System.out.println("\nUid : "+user.getUid()+"\t Name: "+user.getUsername());
		}
			
		
	}
}
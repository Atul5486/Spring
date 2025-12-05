package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.config.AppConfig;
import com.spring.model.User;
import com.spring.service.UserService;

public class MainApplication{
	
	
	public static void main(String args[]) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		JdbcTemplate jdbc=context.getBean(JdbcTemplate.class);
		jdbc.execute("create table if not exists mytable(uid int primary key auto_increment,username varchar(45) not null, email varchar(45) not null,password varchar(45) not null)");
		jdbc.execute("create table if not exists myauditlog(aid int primary key auto_increment,message varchar(45) not null)");
		
		UserService userService=context.getBean(UserService.class);
		
		userService.actionPerformed(new User("andrewDada", "andrew@gmail.com", "andrew@123"	),"Hello audit");
		
		
	}
}

package com.spring.dao;

import org.springframework.stereotype.Service;

@Service
public class UserDao{
	
	public void userService() {
		System.out.println("User service method called !!");
	}
	public void adminService() {
		System.out.println("Admin service method called !!");
	}
	
}
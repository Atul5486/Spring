package com.spring.service;

import java.util.List;

import com.spring.entity.User;

public interface UserService{
	
	public void addUser(User user);
	public List<User> getUserList();
	
}
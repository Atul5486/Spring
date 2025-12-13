package com.spring.dao;

import java.util.List;

import com.spring.entity.User;

public interface UserDao{
	
	public void addUser(User user);
	public List<User> getUserList();
}
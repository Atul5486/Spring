package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDao{

	void addUser(User user);
	User getUser(int id);
	void updateUser(User user);
	void deleteUser(int id);
	List<User> getAllList();
}
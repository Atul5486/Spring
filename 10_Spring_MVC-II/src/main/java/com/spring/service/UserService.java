package com.spring.service;

import java.util.List;

import com.spring.entity.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public User getUser(int id);
	public void deleteUser(int id);
	public List<User> allUser();
}

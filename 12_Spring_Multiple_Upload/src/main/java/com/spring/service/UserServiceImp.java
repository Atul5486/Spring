package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.entity.User;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public UserServiceImp(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

}

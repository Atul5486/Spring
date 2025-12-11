package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.entity.User;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImp implements UserService{
	UserDao userDao;
	
	public UserServiceImp(UserDao userDao) {
		this.userDao =userDao;
	}
	
	
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public boolean checkLogin(String email,String password) {
		return userDao.checkLogin(email, password);
	}
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}
	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	@Override
	public List<User> allUser(){
		return userDao.allUser();
		
	}
}

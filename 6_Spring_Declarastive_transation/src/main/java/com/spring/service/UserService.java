package com.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDao;
import com.spring.model.User;

@Service
public class UserService{

	private UserDao userDao;
	
	public UserService(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Transactional
	public void actionPerformed(User user,String message) {
		
		userDao.addUser(user);
		userDao.addAuditLog(message);
	}
	
}
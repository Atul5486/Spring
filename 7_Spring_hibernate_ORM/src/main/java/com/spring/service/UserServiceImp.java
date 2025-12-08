package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDao;
import com.spring.model.User;


@Service
@Transactional
public class UserServiceImp implements UserService{

	private UserDao userDao;
	
	public UserServiceImp(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void addUserService(User user) {
		userDao.addUser(user);
	}
	
	
	@Override
	public void updateUserService(User user) {
		userDao.updateUser(user);
	}
	
	@Override
	public void deleteUserService(int id) throws Exception{
		userDao.deleteUser(id);
	}
	
	@Override
	public User getUserByIdService(int id) {
			return userDao.getUser(id);
	}
	
	@Override
	public List<User> getAllUserService(){
		return userDao.getAllList();
	}
}
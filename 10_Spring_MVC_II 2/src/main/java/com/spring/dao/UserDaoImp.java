package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDaoImp implements UserDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addUser(User user) {
		em.persist(user);
		System.out.println("User Added Successfully");
		
	}
	@Override
	public void updateUser(User user) {
		em.merge(user);
		System.out.println("User Updated Successfully");
		
	}
	@Override
	public User getUser(int id) {
		return em.find(User.class, id);
	}
	@Override
	public boolean deleteUser(int id) {
		User user=em.find(User.class, id);
		if(user!=null) {
			em.remove(user);
			System.out.println("User Deleted Successfully");
			return true;
		}
		System.out.println("User not found");
		return false;
	}
	@Override
	public List<User> allUser(){
		return em.createQuery("from User",User.class).getResultList();
	}
	@Override
	public boolean checkLogin(String email,String password) {
		
		try {	
		TypedQuery<User> query=em.createQuery("select u from User u where u.email='"+email+"'", User.class);
		User user=query.getSingleResult();
		if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return true;
		}
		}catch(Exception e) {
			System.out.println("Exception occured : "+e);
		}
		return false;
	}
}

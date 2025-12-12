package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.spring.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDaoImp implements UserDao	{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addUser(User user) {
		em.persist(user);
	}
	
	@Override
	public List<User> getUser() {
		return em.createQuery("from User",User.class).getResultList();
	}
}

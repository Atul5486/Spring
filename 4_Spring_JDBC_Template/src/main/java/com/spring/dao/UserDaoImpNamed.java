package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.User;


@Repository
public class UserDaoImpNamed implements UserDao{
		
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public UserDaoImpNamed(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	
	@Override
	public void addUser(User user) {
		String query="insert into userdao(uid,username,email,address) values(:uid,:username,:email,:address)";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("uid",user.getUid());
		map.put("username", user.getUsername());
		map.put("email", user.getEmail());
		map.put("address", user.getAddress());
		namedParameterJdbcTemplate.update(query, map);
		System.out.println("User crated via named parameter ");
	}
	@Override
	public void updateUser(User user) {
		
	}
	
	@Override
	public void deleteUser(int id) {
		
	}
	
	@Override
	public User getUser(int id) {
		return null;
	}
	@Override
	public List<User> allUser() {
		return null;
	}
}
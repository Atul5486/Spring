package com.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public class UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public void addUser(User user) {
		String query="insert into mytable(email,username,password) values(?,?,?)";
		jdbcTemplate.update(query,user.getEmail(),user.getUsername(),user.getPassword());
	}
	
	public void addAuditLog(String message) {
		String query="insert into myauditlog(message) values(?)";
		jdbcTemplate.update(query,message);
		if(true)
			throw new Error("User not eligible");
	}
}
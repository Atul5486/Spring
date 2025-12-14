package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.VerficationToken;

public interface VerificationTokenRepository extends JpaRepository<VerficationToken, Integer>{
	
	public VerficationToken findByToken(String token); 
}
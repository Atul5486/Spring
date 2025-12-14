package com.spring.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.entity.VerficationToken;
import com.spring.repository.VerificationTokenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VerificationTokenService {

	VerificationTokenRepository vtr;
	
	public VerificationTokenService(VerificationTokenRepository vtr) {
		this.vtr=vtr;
	}
	
	public String createVerificationToken(User user) {
		
		VerficationToken vt=new VerficationToken();
		String token=UUID.randomUUID().toString();
		vt.setToken(token);
		vt.setUser(user);
		vt.setLocalDateTime(LocalDateTime.now().plusHours(24));
		return token;
	}
	
	public VerficationToken verifiToken(String token) {
		return vtr.findByToken(token);
	}
	
}

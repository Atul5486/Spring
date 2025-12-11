package com.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="user_mvc")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@NotBlank(message="User name required")
	@Column 
	String username;
	
	@NotBlank(message="Email required")
	@Email(message="please enter a valid email")
	@Column
	String email;
	
	@NotBlank(message="Password is required")
	@Pattern(regexp="^(?=.+?[0-9])(?=.+?[A-Z])(?=.+?[a-z])(?=.+?[~!@#$%^&*()_+]).{8}$", message="Password must contains one special character, one digit, one uppercase, one lowercase and it should be 8 characters in length")
	@Column
	String password;
	
	@NotBlank(message="Gender required")
	@Column
	String gender;
	
	@NotBlank(message="hobbies required")
	@Column
	String hobbies;
	
	@NotBlank(message="Subject required")
	@Column
	String subject;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "User [getUid()=" + getUid()+ ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getGender()=" + getGender() + ", getHobbies()=" + getHobbies() + ", getSubject()=" + getSubject()
				+ "]";
	}
	
	
}
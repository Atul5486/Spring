package com.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.User;
import com.spring.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController{
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
	public String index(Model model ) {
		model.addAttribute("message","this is Index page");
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("message","This is register page");
		return "register";
	}
	
	@PostMapping(value="/registerData",produces = "application/json",consumes = "application/json")
	@ResponseBody
	public Map<String, Object> register(@Valid @RequestBody User user,BindingResult result){
		Map<String ,Object> map=new HashMap<String, Object>();
		
		if(result.hasErrors()) {
			String []fields= {"username","email","password","gender","hobbies","subject"};
			for(String field:fields) {
				if(result.getFieldError(field)!=null) {
				map.put("field", field);
				map.put("message", result.getFieldError(field).getDefaultMessage());
				map.put("status", 400);
				return map;
				}
			}
		}
		try {
			userService.addUser(user);
			map.put("status", 201);
			map.put("message", "User Added successfully");
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Error while adding user"+e);
			map.put("message", "Something went wrong");
			map.put("status",500);
		}	
		return map;
		}
		
	
}
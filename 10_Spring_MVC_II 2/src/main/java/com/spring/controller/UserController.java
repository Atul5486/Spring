package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.User;
import com.spring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
		model.addAttribute("user",new User());
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
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("message", "This is login page");
		return "login";
	}
	
	@PostMapping("/loginData")
	public String loginData(@ModelAttribute User obj,Model model,HttpServletRequest request) {
		boolean res=userService.checkLogin(obj.getEmail(),obj.getPassword());
		System.out.println(obj);
		if(res) {
			HttpSession session=request.getSession();
			session.setAttribute("email", obj.getEmail());
			return "profile";
		}else {			
		model.addAttribute("message", "Invalid credential");
		return "login";
		}
	}
	@GetMapping("/viewList")
	public String viewList(Model model) {
		model.addAttribute("userList",userService.allUser());
		return "viewUserList";
	}
	
	@GetMapping("/updateUser/{id}")
	public String updateUserForm(@PathVariable("id") int id,Model model) {
		model.addAttribute("userObj",userService.getUser(id));
		return "updateForm";
	}
	@PostMapping("/updateFormData")
	public String updateFormData(@ModelAttribute User user,  Model model) {
		userService.updateUser(user);
		model.addAttribute("userList", userService.allUser());
		model.addAttribute("message","Data Updated Successfully");
		return "viewUserList";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("uid") int id,Model model) {
		boolean result=userService.deleteUser(id);
		if(result) {
			model.addAttribute("message","User deleted successfully");
			model.addAttribute("userObj", userService.allUser());
		}else {
			model.addAttribute("message","Error while deleting user");
			model.addAttribute("userObj", userService.allUser());
		}
		return "viewUserList";
	}
	@GetMapping("/profile")
	public String profile(Model model) {
			model.addAttribute("messaage","Hello" );
			return "profile";
	}
	@GetMapping("/logout")
	public String logout(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.setAttribute("email", "");
		session.invalidate();
		model.addAttribute("message", "Logout Successfully");
		return "login";
	}
}
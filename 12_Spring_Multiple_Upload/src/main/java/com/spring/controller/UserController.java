package com.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.UserDto;
import com.spring.entity.User;
import com.spring.service.UserService;

@Controller
public class UserController{
	
	@Autowired
	private Environment env;
	
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadFormData";
	}
	
	@PostMapping("/uploadFormData")
	public String uploadFormData(@ModelAttribute UserDto userDto,Model model) throws IOException{
		
		MultipartFile files[]=userDto.getFilename();
		String filePath=env.getProperty("upload.filepath");
		File uploadPath=new File(filePath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		StringBuilder sb=new StringBuilder();
		for(MultipartFile file:files) {
			String fileName=System.currentTimeMillis()+file.getOriginalFilename();
			File destination=new File(uploadPath,fileName);
			file.transferTo(destination);
			sb.append(fileName).append(",");
		}
		String str=sb.toString();
		String fileNames=str.substring(0,str.length()-1);
		System.out.println(sb);
		User user=new User();
		user.setFilename(fileNames);
		user.setUsername(userDto.getUsername());
		user.setDescription(userDto.getDescription());
		
		userService.addUser(user);
		model.addAttribute("message", "file uploaded Successfully");
		
		return "uploadFormData";
	}
	
	
	@GetMapping("/viewAllList")
	public String viewAllList(Model model) {
		model.addAttribute("userList",userService.getUserList());
		return "viewAllList";
	}
}
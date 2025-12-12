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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.UserDto;
import com.spring.entity.User;
import com.spring.service.UserService;

@Controller
public class UserController{
	
	UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@Autowired
	public Environment env; 
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadFormData";
	}
	
	@PostMapping("/uploadFormData")
	public String uploadFormData(
	        @RequestParam("username") String username,
	        @RequestParam("description") String description,
	        @RequestParam("filename") MultipartFile file,
	        Model model) throws IOException {

	    String filePath = env.getProperty("upload.filepath");
	    File uploadDir = new File(filePath);

	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }
	    System.out.println("Content Type"+file.getContentType());
	    System.out.println("File class"+file.getClass());
	    System.out.println("Input Stream"+file.getInputStream());

	    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	    File destination = new File(uploadDir, fileName);

	    file.transferTo(destination);

	    User user = new User();
	    user.setUsername(username);
	    user.setDescription(description);
	    user.setFilename(fileName);

	    userService.addUser(user);

	    model.addAttribute("message", "File uploaded successfully");

	    return "uploadFormData";
	}


	
	@GetMapping("/viewAllList")
	public String viewlist(Model model){
		model.addAttribute("listData", userService.getUser());
		return "viewAllList";
	}
}
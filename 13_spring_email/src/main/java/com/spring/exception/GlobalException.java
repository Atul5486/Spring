package com.spring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException{
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex,Model model) {
		model.addAttribute("error", ex.getMessage());
		
		return "failure_page";
	}
}
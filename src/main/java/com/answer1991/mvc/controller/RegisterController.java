package com.answer1991.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	
	@RequestMapping("/register.html")
	public String handleGoToRegisterPage() {
		return "register";
	}
	
}

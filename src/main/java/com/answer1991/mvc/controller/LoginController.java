package com.answer1991.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String handle(ModelMap model, HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
}

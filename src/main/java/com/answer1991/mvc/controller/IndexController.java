package com.answer1991.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.answer1991.mvc.pojo.InputUser;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class IndexController {
	@RequestMapping("")
	public ModelAndView handle(@ModelAttribute("user")InputUser user) {
		//throw new RuntimeException("error");
		return new ModelAndView("register");
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public ModelAndView noSeesionAttributes(HttpSessionRequiredException ex) {
		//ex.printStackTrace();
		return new ModelAndView("login");
	}
}

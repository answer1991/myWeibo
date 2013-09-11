package com.answer1991.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.ServiceFacade;

@Controller
public class DoRegisterController {
	@Autowired
	private ServiceFacade service;
	
	@RequestMapping("/doRegister.html")
	public ModelAndView hanlde(@ModelAttribute InputUser inputUser) {
		service.saveUser(inputUser);
		return new ModelAndView("success");
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView handleUserExistsException(DataIntegrityViolationException ex) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("errorInfo", "用户已存在");
		return mav;
	}
	
	@ModelAttribute
	public InputUser setUser(@RequestParam String email, @RequestParam String password) {
		InputUser user = new InputUser();
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}

	public ServiceFacade getService() {
		return service;
	}

	public void setService(ServiceFacade service) {
		this.service = service;
	}
}

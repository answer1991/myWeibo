package com.answer1991.mvc.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.ServiceFacade;

@Controller
public class DoLoginController {
	@Autowired
	private ServiceFacade service;
	
	@RequestMapping("/doLogin.html")
	public String hanlde(@ModelAttribute InputUser inputUser) {
		User user = service.queryUserByEmailAndPassword(inputUser.getEmail(), inputUser.getPassword());
		return "success";
	}
	
	@ExceptionHandler(NoResultException.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView handleNoResultException(NoResultException ex) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("errorInfo", "用户名不存在或者密码错误!");
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

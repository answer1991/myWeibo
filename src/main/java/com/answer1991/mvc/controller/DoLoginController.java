package com.answer1991.mvc.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.ServiceFacade;

@Controller
public class DoLoginController {
	@Autowired
	private ServiceFacade service;
	
	@RequestMapping("/doLogin")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public String hanlde(@ModelAttribute InputUser inputUser, HttpSession session) {
		User user = service.queryUserByEmailAndPassword(inputUser.getEmail(), inputUser.getPassword());
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	@ExceptionHandler(NoResultException.class)
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public String handleNoResultException(NoResultException ex, HttpServletRequest request) {
	    FlashMap redirectAttributes = RequestContextUtils.getOutputFlashMap(request);
	    redirectAttributes.put("userNotFoundError", "exception.login.userNotFound");
	    redirectAttributes.put("emailPlaceholder", request.getParameter("email"));
		return "redirect:/login";
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

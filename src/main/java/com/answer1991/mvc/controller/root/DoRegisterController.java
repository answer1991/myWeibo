package com.answer1991.mvc.controller.root;

import java.util.Locale;

import javax.servlet.http.HttpSession;

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

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.UserService;

@Controller
public class DoRegisterController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/doRegister")
	public String hanlde(@ModelAttribute InputUser inputUser, HttpSession session) {
		User user = service.registerUser(inputUser);
		session.setAttribute("userId", user.getId());
		return "redirect:/gallery/";
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public ModelAndView handleUserExistsException(DataIntegrityViolationException ex) {
		ex.printStackTrace();
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("errorInfo", "用户已存在");
		return mav;
	}
	
	@ModelAttribute
	public InputUser setUser(@RequestParam String nickname, @RequestParam String email, @RequestParam String password, Locale locale) {
		InputUser user = new InputUser();
		user.setNickname(nickname);
		user.setEmail(email);
		user.setPassword(password);
		user.setLocale(locale);
		return user;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
}

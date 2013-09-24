package com.answer1991.mvc.controller.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.answer1991.entity.User;

@Controller
@SessionAttributes("userId")
public class IndexController {
	@RequestMapping("/")
	public String handle(@ModelAttribute("userId")long userId) {
		return "redirect:/gallery/";
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String noSeesionAttributes(HttpSessionRequiredException ex) {
		//ex.printStackTrace();
		return "login";
	}
}

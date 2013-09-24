package com.answer1991.mvc.controller.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.answer1991.service.UserService;

@Controller
@RequestMapping("/gallery")
@SessionAttributes("userId")
public class UploadPhotoController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/uploadPhoto")
	public String handle(@ModelAttribute("userId")Long userId, ModelMap model) { 
		model.addAttribute("user", userService.queryUserById(userId));
		return "gallery/uploadPhoto";
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String noSeesionAttributes(HttpSessionRequiredException ex) {
		//ex.printStackTrace();
		return "redirect:/login";
	}
}

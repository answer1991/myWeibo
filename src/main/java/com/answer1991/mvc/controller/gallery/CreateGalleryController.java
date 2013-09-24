package com.answer1991.mvc.controller.gallery;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/gallery")
@SessionAttributes("userId")
public class CreateGalleryController {
	@RequestMapping("/createGallery")
	public String handle(@ModelAttribute("userId")Long userId) {
		return "gallery/createGallery";
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String noSeesionAttributes(HttpSessionRequiredException ex) {
		//ex.printStackTrace();
		return "redirect:/login";
	}
}

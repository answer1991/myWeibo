package com.answer1991.mvc.controller.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputGallery;
import com.answer1991.service.GalleryService;
import com.answer1991.service.UserService;

@Controller
@RequestMapping("/gallery")
@SessionAttributes("userId")
public class DoCreateGalleryController {
	@Autowired
	private GalleryService galleryService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/doCreateGallery")
	public String handle(@ModelAttribute("userId")Long userId, @ModelAttribute("inputGallery")InputGallery inputGallery) {
		User user = userService.queryUserById(userId);
		galleryService.createGallery(user, inputGallery);
		return "redirect:/gallery/";
	}
	
	@ModelAttribute
	public InputGallery initInputGallery(@RequestParam("galleryName") String galleryName, @RequestParam("galleryDescription") String galleryDescription) {
		InputGallery gallery = new InputGallery();
		gallery.setName(galleryName);
		gallery.setDescription(galleryDescription);
		return gallery;
	}
}

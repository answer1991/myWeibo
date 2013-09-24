package com.answer1991.mvc.controller.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.answer1991.dao.UserDao;
import com.answer1991.entity.User;
import com.answer1991.service.UserService;

@Controller
@RequestMapping("/gallery")
public class ListGalleryController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{beViewedUserId}")
	public String handle() {
		return "gallery/myGallery"; 
	}
	
	@ModelAttribute("beViewedUser")
	public User initUser(@PathVariable String beViewedUserId) {
		return userService.queryUserById(beViewedUserId);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

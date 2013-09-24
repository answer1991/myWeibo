package com.answer1991.mvc.controller.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.answer1991.entity.Photo;
import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputPhoto;
import com.answer1991.service.PhotoService;
import com.answer1991.service.UserService;

@Controller
@RequestMapping("/gallery")
@SessionAttributes("userId")
public class DoUploadPhotoController {
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/doUploadPhoto")
	public String handle(@ModelAttribute("userId")Long userId, InputPhoto inputPhoto, RedirectAttributes model) {
		User user = userService.queryUserById(userId); 
		Photo photo = photoService.savePhoto(user, inputPhoto);
		return "redirect:/gallery/detail/" + inputPhoto.getGalleryId(); 
	}
	
	@ModelAttribute
	public InputPhoto inintInputPhoto(@RequestParam String photoName, @RequestParam String photoDescription, @RequestParam Integer gallerySelect, @RequestParam MultipartFile photoFile) {
		InputPhoto photo = new InputPhoto();
		System.out.println(photoName);
		System.out.println(photoDescription);
		System.out.println(gallerySelect);
		System.out.println(photoFile.getSize());
		photo.setName(photoName);
		photo.setDescription(photoDescription);
		photo.setGalleryId(gallerySelect);
		photo.setFile(photoFile);
		return photo;
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String noSeesionAttributes(HttpSessionRequiredException ex) {
		//ex.printStackTrace();
		return "login";
	}
}

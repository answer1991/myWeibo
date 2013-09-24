package com.answer1991.mvc.controller.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.answer1991.entity.Gallery;
import com.answer1991.service.GalleryService;

@Controller
@RequestMapping("/gallery")
public class ViewGalleyDetailsController {
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("/detail/{galleryId}")
	public String handle() {
		
		return "gallery/galleryDetails";
	}
	
	@ModelAttribute
	public Gallery initGallery(@PathVariable String galleryId) {
		System.out.println(galleryId);
		Gallery gallery = galleryService.queryGalleryById(galleryId);
		return gallery;
	}

	public GalleryService getGalleryService() {
		return galleryService;
	}

	public void setGalleryService(GalleryService galleryService) {
		this.galleryService = galleryService;
	}
	
	
}

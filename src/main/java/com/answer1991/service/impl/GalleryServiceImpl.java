package com.answer1991.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.answer1991.dao.GalleryDao;
import com.answer1991.dao.UserDao;
import com.answer1991.entity.Gallery;
import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputGallery;
import com.answer1991.service.GalleryService;

public class GalleryServiceImpl implements GalleryService {
	@Autowired
	private GalleryDao galleryDao;
	
	@Override
	public Gallery createGallery(User user, InputGallery inputGallery) {
		Gallery gallery = new Gallery();
		gallery.setUser(user);
		gallery.setName(inputGallery.getName());
		gallery.setDescription(inputGallery.getDescription());
		galleryDao.saveGallery(gallery);
		return gallery;
	}
	
	@Override
	public Gallery queryGalleryById(Serializable id) {
		return galleryDao.queryById(id);
	}

}

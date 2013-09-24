package com.answer1991.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.answer1991.dao.GalleryDao;
import com.answer1991.dao.PhotoDao;
import com.answer1991.entity.Gallery;
import com.answer1991.entity.Photo;
import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputPhoto;
import com.answer1991.service.PhotoService;
import com.answer1991.web.multipart.PhotoUploadProcessor;

public class PhotoServiceImpl implements PhotoService {
	@Autowired
	private PhotoDao photoDao;
	@Autowired
	private GalleryDao galleryDao;
	@Autowired
	private PhotoUploadProcessor fileProcessor;
	
	@Override
	public Photo savePhoto(User user, InputPhoto inputPhoto) {
		Photo photo = new Photo();
		photo.setName(inputPhoto.getName());
		photo.setDescription(inputPhoto.getDescription());
		String photoUrl = fileProcessor.processPart(inputPhoto.getFile());
		photo.setPhotoUrl(photoUrl);
		
		Gallery gallery = galleryDao.queryById(inputPhoto.getGalleryId());
		gallery.setUser(user);
		photo.setGallery(gallery);
		
		photoDao.savePhoto(photo);
		
		return photo;
	}

}

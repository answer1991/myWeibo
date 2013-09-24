package com.answer1991.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.answer1991.entity.Gallery;
import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputGallery;

@Transactional
public interface GalleryService {
	public abstract Gallery createGallery(User user, InputGallery inputGallery);
	public abstract Gallery queryGalleryById(Serializable id);
}

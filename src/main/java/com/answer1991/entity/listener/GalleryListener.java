package com.answer1991.entity.listener;

import javax.persistence.PostLoad;

import com.answer1991.entity.Gallery;

public class GalleryListener {
	@PostLoad
	public void initPhotoes(Object object) {
		Gallery gallery = (Gallery) object;
		gallery.getPhotoes().size();
	}
}

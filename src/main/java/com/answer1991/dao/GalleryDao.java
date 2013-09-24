package com.answer1991.dao;

import java.io.Serializable;

import com.answer1991.entity.Gallery;

public interface GalleryDao {
	public abstract void saveGallery(Gallery gallery);
	public abstract Gallery queryById(Serializable id);
}

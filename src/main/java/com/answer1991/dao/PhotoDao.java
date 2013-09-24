package com.answer1991.dao;

import java.io.Serializable;

import com.answer1991.entity.Photo;

public interface PhotoDao {
	public abstract Photo queryById(Serializable id);
	public abstract void savePhoto(Photo photo);
}

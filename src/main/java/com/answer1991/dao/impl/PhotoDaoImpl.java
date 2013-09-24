package com.answer1991.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.answer1991.dao.PhotoDao;
import com.answer1991.entity.Photo;

public class PhotoDaoImpl implements PhotoDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Photo queryById(Serializable id) {
		return em.find(Photo.class, id);
	}
	
	@Override
	public void savePhoto(Photo photo) {
		em.persist(photo);
	}
	
}

package com.answer1991.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.answer1991.dao.GalleryDao;
import com.answer1991.entity.Gallery;

public class GalleryDaoImpl implements GalleryDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveGallery(Gallery gallery) {
		em.persist(gallery);
	}
	
	@Override
	public Gallery queryById(Serializable id) {
		return em.find(Gallery.class, id);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}

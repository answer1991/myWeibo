package com.answer1991.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.answer1991.dao.UserDao;
import com.answer1991.entity.User;

public class UserDaoImpl implements UserDao {
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void saveUser(User user) {
		em.persist(user);
	}
	
	@Override
	public User mergeUser(User user) {
		return em.merge(user); 
	}
	
	@Override
	public void refreshUser(User user) {
		em.refresh(user);
	}
	
	@Override
	public User queryById(Serializable id) {
		return em.find(User.class, id);
	}

	@Override
	public User queryByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmailAndPassword", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		return query.getSingleResult();
	}
	
	@Override
	public User queryByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}

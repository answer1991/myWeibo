package com.answer1991.dao;

import java.io.Serializable;

import com.answer1991.entity.User;

public interface UserDao {
	public abstract void refreshUser(User user);
	public abstract User mergeUser(User user);
	public abstract void saveUser(User user);
	public abstract User queryByEmail(String email);
	public abstract User queryById(Serializable id);
	public abstract User queryByEmailAndPassword(String email, String password);
}

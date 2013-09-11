package com.answer1991.dao;

import com.answer1991.entity.User;

public interface UserDao {
	public abstract void saveUser(User user);
	public abstract User queryByEmail(String email);
	public abstract User queryByEmailAndPassword(String email, String password);
}

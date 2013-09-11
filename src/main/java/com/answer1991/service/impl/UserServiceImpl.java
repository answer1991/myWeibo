package com.answer1991.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.answer1991.dao.UserDao;
import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.UserService;


public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public void saveUser(InputUser inputUser) {
		User user = new User();
		user.setEmail(inputUser.getEmail());
		user.setPassword(inputUser.getPassword());
		userDao.saveUser(user);
	}

	@Override
	public User queryUserByEmailAndPassword(String email, String password) {
		return userDao.queryByEmailAndPassword(email, password);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}

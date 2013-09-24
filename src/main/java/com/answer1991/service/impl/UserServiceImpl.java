package com.answer1991.service.impl;

import java.io.Serializable;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.answer1991.dao.UserDao;
import com.answer1991.entity.User;
import com.answer1991.entity.myenum.AccountIsActive;
import com.answer1991.entity.myenum.Sex;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.UserService;


public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public void refreshUser(User user) {
		userDao.refreshUser(user);
	}
	
	@Override
	public User mergeUser(User user) {
		return userDao.mergeUser(user);
	}
	
	
	@Override
	public User registerUser(InputUser inputUser) {
		User user = new User();
		user.setEmail(inputUser.getEmail());
		user.setPassword(inputUser.getPassword());
		user.setNickname(inputUser.getNickname());
		user.setLocale(inputUser.getLocale().toString());
		//set default properties.
		/*
		user.setIsActive(AccountIsActive.NOTACTIVE);
		user.setSex(Sex.UNKNOWN);
		Calendar now = Calendar.getInstance();
		user.setRegisterDate(now);
		user.setLastLoginDate(now);
		
		*/
		userDao.saveUser(user);
		return user;
	}

	@Override
	public User queryUserById(Serializable id) {
		return userDao.queryById(id);
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

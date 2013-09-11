package com.answer1991.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.ServiceFacade;
import com.answer1991.service.UserService;


public class ServiceFacadeImpl implements ServiceFacade {
	@Autowired
	private UserService userSerivce;
	
	@Override
	public void saveUser(InputUser inputUser) {
		userSerivce.saveUser(inputUser);
	}

	@Override
	public User queryUserByEmailAndPassword(String email, String password) {
		return userSerivce.queryUserByEmailAndPassword(email, password);
	}

	public UserService getUserSerivce() {
		return userSerivce;
	}

	public void setUserSerivce(UserService userSerivce) {
		this.userSerivce = userSerivce;
	}
}

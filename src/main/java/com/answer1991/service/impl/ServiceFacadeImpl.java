package com.answer1991.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.ServiceFacade;
import com.answer1991.service.UserService;


public class ServiceFacadeImpl implements ServiceFacade {
	@Autowired
	private UserService userSerivce;
	
	@Override
	public User registerUser(InputUser inputUser) {
		return userSerivce.registerUser(inputUser);
	}
	
	@Override
	public User queryUserById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void refreshUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public User mergeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}

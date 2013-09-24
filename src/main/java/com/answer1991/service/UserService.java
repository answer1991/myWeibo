package com.answer1991.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;

@Transactional
public interface UserService {
	public abstract void refreshUser(User user);
	public abstract User mergeUser(User user);
	public abstract User queryUserById(Serializable id);
	public abstract User registerUser(InputUser inputUser);
	public abstract User queryUserByEmailAndPassword(String email, String password);
}

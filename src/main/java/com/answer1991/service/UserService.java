package com.answer1991.service;

import org.springframework.transaction.annotation.Transactional;

import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputUser;

@Transactional
public interface UserService {
	public abstract User saveUser(InputUser inputUser);
	public abstract User queryUserByEmailAndPassword(String email, String password);
}

package com.answer1991.service;

import org.springframework.transaction.annotation.Transactional;

import com.answer1991.entity.Photo;
import com.answer1991.entity.User;
import com.answer1991.mvc.pojo.InputPhoto;

@Transactional
public interface PhotoService {
	public abstract Photo savePhoto(User user, InputPhoto inputPhoto);
}

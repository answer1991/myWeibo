package com.answer1991.entity.listener;

import javax.persistence.PostLoad;

import com.answer1991.entity.User;

public class UserListener {
	@PostLoad
	public void addFollowAndFansCount(Object object) {
		User user = (User) object;
		System.out.println("123");
		System.out.println("gallerySize: " + user.getGalleries().size());
		//user.setFansCount((Interger)user.getFans().size());
		//user.setFollowsCount(user.getFollows().size());
	}
}

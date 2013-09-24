package com.answer1991.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.answer1991.entity.User;
import com.answer1991.service.UserService;

public class TestFollowAndFans {
	private AbstractApplicationContext cxt;

	@Before
	public void init() {
		this.cxt = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		this.cxt.registerShutdownHook();
	}

	@Test
	public void test() throws Exception {
		UserService service = this.cxt
				.getBean("userService", UserService.class);
		System.out.println(service);
		User user = service.queryUserByEmailAndPassword("1234", "1234");
		System.out.println(user.getFansCount());
		System.out.println(user.getFollowsCount());
		List<User> fans = user.getFans();
		for(User fan : fans) {
			System.out.println("fans :" + fan.getEmail());
		}
		
		List<User> follows = user.getFollows();
		for(User follow : follows) {
			System.out.println("follow :" + follow.getEmail());
		}
	}
}

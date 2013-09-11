package com.answer1991.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.answer1991.mvc.pojo.InputUser;
import com.answer1991.service.UserService;

public class TestUserDaoImpl {
	private AbstractApplicationContext cxt;
	
	@Before
	public void init() {
		this.cxt = new ClassPathXmlApplicationContext("spring-orm-config/spring-orm-config.xml");
	}
	
	@Test
	public void test() throws Exception {
		UserService service = this.cxt.getBean("userService", UserService.class);
		InputUser user = new InputUser();
		user.setEmail("12345");
		user.setPassword("12345");
		service.saveUser(user);
	}
}

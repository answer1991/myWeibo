package com.answer1991.mvc.pojo;

import java.util.Locale;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class InputUser {
	@NotNull
	@Size(min = 8, max = 100)
	private String email;
	@NotNull
	@Size(min = 8, max = 30)
	private String password;
	@Size(min = 6, max = 25)
	private String nickname;
	
	@NotNull
	private Locale locale;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}

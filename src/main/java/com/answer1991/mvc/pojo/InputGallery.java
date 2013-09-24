package com.answer1991.mvc.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InputGallery {
	@NotNull
	private String name;
	
	@NotNull
	@Size(max = 100)
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

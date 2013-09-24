package com.answer1991.mvc.pojo;

import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class InputPhoto {
	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private MultipartFile file;
	@NotNull
	private Integer galleryId;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(Integer galleryId) {
		this.galleryId = galleryId;
	}

}

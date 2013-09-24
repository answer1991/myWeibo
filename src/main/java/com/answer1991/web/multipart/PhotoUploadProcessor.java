package com.answer1991.web.multipart;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoUploadProcessor {
	public abstract String processPart(MultipartFile file);
}

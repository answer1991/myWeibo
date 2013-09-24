package com.answer1991.web.multipart.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.answer1991.web.multipart.PhotoUploadProcessor;

public class SimplePhotoUploadProcessor implements PhotoUploadProcessor {
	
	private String targetPath = "c:/webapp/imgUpload";
	
	private String pathPrefix = "/imgUpload";
	
	@Override
	public String processPart(MultipartFile file) {
		String targetFileName = generateFileName(file);
		String targetFilePath = targetPath + "/" + targetFileName;
		try {
			File targetFile = new File(targetFilePath);
			targetFile.createNewFile();
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pathPrefix + "/" + targetFileName;
	}
	
	private String generateFileName(MultipartFile file) {
		String name = UUID.randomUUID().toString() + file.getOriginalFilename();
		return name;
	}
}

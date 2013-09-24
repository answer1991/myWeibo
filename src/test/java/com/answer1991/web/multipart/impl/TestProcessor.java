package com.answer1991.web.multipart.impl;

import org.junit.Before;
import org.junit.Test;

public class TestProcessor {
	private SimplePhotoUploadProcessor processor;
	
	@Before
	public void init() {
		processor = new SimplePhotoUploadProcessor();
	}
	
	@Test
	public void test() {
		processor.processPart(null);
	}
}

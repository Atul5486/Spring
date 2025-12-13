package com.spring.config;

import java.io.File;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.Registration;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.MultipartConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	private static final long MAX_FILE_SIZE=20*1024*1024;
	private static final long MAX_REQUEST_SIZE=40*1024*1024;
	private static final int FILE_THRESHOLD=0;
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {HibernateConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	public void customizeRegistration(ServletRegistration.Dynamic registration) {
		File uploadFile=new File("uploadDemo");
		if(!uploadFile.exists()) {
			uploadFile.mkdir();
		}
		
		MultipartConfigElement multipartConfigElement=new MultipartConfigElement(
				uploadFile.getAbsolutePath(),
				MAX_FILE_SIZE,
				MAX_REQUEST_SIZE,
				FILE_THRESHOLD
				);
		registration.setMultipartConfig(multipartConfigElement);
	}
	
}
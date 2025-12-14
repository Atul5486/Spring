package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring")
public class AppConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		irvr.setSuffix(".jsp");
		irvr.setPrefix("/WEB-INF/views/");
		return irvr;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/css/**")
		.addResourceLocations("/css/");
	registry
		.addResourceHandler("/images/**")
		.addResourceLocations("/images/");
	registry
		.addResourceHandler("/js/**")
		.addResourceLocations("/js/");
	}
	
}
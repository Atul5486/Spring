package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.spring")
public class AppConfig{
	
	@Bean
	public Demo1Service demo1Service() {
		return new Demo1Service();
	}
}
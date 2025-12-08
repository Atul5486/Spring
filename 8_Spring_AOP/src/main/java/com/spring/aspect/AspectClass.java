package com.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass{
	
	@Pointcut("execution(* com.spring.dao.*.*(..))")
	public void service() {}
	
	@After("service()")
	public void afterInvoke() {
		System.out.println("After method invoke");
	}
	
	@Before("service()")
	public void beforeInvoke() {
		System.out.println("Before invoke method called");
	}
	
	@AfterReturning("service()")
	public void afterReturning() {
		System.out.println("After returning method invoke");
	}
	
}
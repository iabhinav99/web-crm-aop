package com.abhinav.springdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.abhinav.springdemo.entity.Customer;

@Aspect
@Component
public class myLoggingAspect {

	// Declare Point cut

	// Declare point cut for all controller package
	@Pointcut("execution(* com.abhinav.springdemo.controller.*.*(..))")
	public void forController() {}

	// Declare point cut for all controller package
	@Pointcut("execution(* com.abhinav.springdemo.dao.*.*(..))")
	public void forDAO() {}

	// Declare point cut for all controller package
	@Pointcut("execution(* com.abhinav.springdemo.service.*.*(..))")
	public void forService() {}
    
	// Combine all the point cut
	@Pointcut("forController()||forDAO()||forService()")
	public void forFlow() {}
	
	// Create before advice
	@Before("forFlow()")
	public void beforFlowAdvice(JoinPoint joinPoint) {
		
		MethodSignature methodSign=(MethodSignature) joinPoint.getSignature();
		System.out.println("===> Executing @before advice on method - "+methodSign);
		
		// get method args
		
		Object[] args=joinPoint.getArgs();
		
		for(Object tmpArg : args) {
		 System.out.println("===> Arguments are : "+tmpArg);	
		}
	}
	
	// Add after returning advice
	
	@AfterReturning(pointcut="forFlow()",returning="result")
	public void afterFlowAdvice(JoinPoint joinPoint, List<Customer> result) {
		
		MethodSignature methodSign=(MethodSignature) joinPoint.getSignature();
		System.out.println("===> Executing @after Returning advice on method - "+methodSign);
		
		// Display results
		
		System.out.println("result :"+result);
		
		
	}
	
}









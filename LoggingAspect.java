package com.example.demo.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		System.out.println("Started: "+ joinPoint.getSignature().getName());
		try {
		return joinPoint.proceed();
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println("Completed: "+ joinPoint.getSignature().getName());
			System.out.println("Execution time : "+ (endTime-startTime)+ "ms");
		}
		
	}
}

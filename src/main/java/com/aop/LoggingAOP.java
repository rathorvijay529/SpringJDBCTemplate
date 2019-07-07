package com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAOP {

	private Logger logger = Logger.getLogger(this.getClass());

	@Before("execution(* com.service.*.*(..))")
	public void beforeAdvise(JoinPoint joinPoint) {
		logger.info("Inside class ::"
				+ joinPoint.getTarget().getClass().getName());
		logger.info("Method name::" + joinPoint.getSignature().getName()
				+ " Starting..");
		logger.info("RunnTime argument::" + joinPoint.getArgs().length);
		Object[] signatureArgs = joinPoint.getArgs();
		for (Object signatureArg : signatureArgs) {
			int count = 0;
			logger.info("Arg:" + (++count) + "::" + signatureArg);
		}
	}

	@After("execution(* com.service.*.*(..))")
	public void afterAdvise(JoinPoint joinPoint) {
		logger.info("Method name::" + joinPoint.getSignature().getName()
				+ " ended..");
	}

	@AfterReturning(pointcut = "execution(* com.service.*.*(..))", returning = "returnValue")
	public void afterReturningAdvise(JoinPoint joint, Object returnValue) {
		logger.info(" return::" + returnValue);
		logger.info("Method run successfully No error no Exception");
	}

	@AfterThrowing(pointcut = "execution(* com.service.*.*(..))", throwing = "exception")
	public void logAfterThrowingAllMethods(Exception exception)
			throws Throwable {
		logger.info("****LoggingAspect.logAfterThrowingAllMethods() "
				+ exception);
	}

	/*@Around("execution(* com.service.*.*(..))")
	public void logAroundAllMethods(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.info("Around advice");
		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			logger.info("Arguments passed: ");
			for (int i = 0; i < args.length; i++) {
				logger.info("arg " + (i + 1) + ": " + args[i]);
			}
		}
		Object result = joinPoint.proceed(args);
		logger.info("Returning " + result);
	}*/

}

package com.app.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.graalvm.compiler.lir.CompositeValue.Component;


@Component
@Aspect //To Tell SC , whatever follows contains cross cutting concerns(WHAT,WHEN,WHERE) : Advisor
public class LoggerAspect {
	
	@Before("execution (* com.app.bank.*.*(..))")
	public void logIt() {

		System.out.println("Logging details");
	}

}

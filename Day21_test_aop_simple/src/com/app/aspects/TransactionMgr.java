package com.app.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TransactionMgr {
	@Pointcut("execution (* com.app.bank.*.*(double))")
	public void test()
	{}

	@Before(value="test()")
	public void beginTransaction()
	{
		System.out.println("beginning tx");
	}
	@AfterReturning(value="test()")
	public void commitTransaction()
	{
		System.out.println("committing tx");
	}
	@AfterThrowing(value="test()")
	public void discardTransaction()
	{
		System.out.println("rolling back tx");
	}
	

}

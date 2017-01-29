package spring.ex08.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Animal {
	@Pointcut("execution( * *.eat(..))")
	public void eating(){}
	
	@Before("eating()")
	public void rush(){
		System.out.println("주인에게 달려와용");
	}
	
	@After("eating()")
	public void sleep(){
		System.out.println("먹은 후에 자요");
	}
}

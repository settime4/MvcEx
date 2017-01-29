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
		System.out.println("���ο��� �޷��Ϳ�");
	}
	
	@After("eating()")
	public void sleep(){
		System.out.println("���� �Ŀ� �ڿ�");
	}
}

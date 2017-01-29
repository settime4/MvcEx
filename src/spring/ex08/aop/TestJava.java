package spring.ex08.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex01/aop/bean-aop-declare.xml");
		Dog dog1 = (Dog)ctx.getBean("dog");
		dog1.eat();
		Cat cat1 = (Cat)ctx.getBean("cat");
		cat1.eat();
	}
}

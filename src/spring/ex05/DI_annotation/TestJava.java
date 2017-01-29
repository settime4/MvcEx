package spring.ex05.DI_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex05/DI_annotation/bean-annotation.xml");
		Employee e1 = (Employee)ctx.getBean("employee");
		e1.dept.work();
	}
}

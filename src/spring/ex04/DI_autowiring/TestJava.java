package spring.ex04.DI_autowiring;

import java.util.Iterator;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex05/DI_autowiring/bean-autowiring.xml");
		Employee e1 = (Employee)ctx.getBean("employee");
		System.out.println(e1.name);
		
	}
}

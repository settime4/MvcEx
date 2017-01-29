package spring.ex02.DI_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex02/DI_property/bean-property.xml");
		Employee e = (Employee) ctx.getBean("employee02");
		System.out.println(e.dept.name+" 부서의 사원 : "+e.name);
	}
}

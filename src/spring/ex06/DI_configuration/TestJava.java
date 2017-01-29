package spring.ex06.DI_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex06/DI_configuration/bean-configuration.xml");
		Department dp1 =(Department) ctx.getBean("dept01");
		Department dp2 =(Department) ctx.getBean("dept02");
		Employee ep1 = (Employee) ctx.getBean("emp01");
		Employee ep2 = (Employee) ctx.getBean("emp02");
		
		dp1.work();
		dp2.work();
		ep1.dept.work();
		System.out.println(((BusinessTeam) ep2.dept).getName());
	}
}

package spring.ex01.DI_proto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDeclareTest {
	public static void main(String args[]){

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex01/DI_proto/bean-declare.xml");
		Dog d23 = new Dog();
		d23.bow();
		
		Dog d = (Dog) ctx.getBean("dog");
		d.sleep();		
		d.bow();
		Cat c = (Cat) ctx.getBean("cat");
		System.out.println(c.name);
		Dog d2 = (Dog) ctx.getBean("dog2");
		d2.bow();
		
		System.out.println("====���丮 �޼ҵ带 �̿���====");
		Zoo z = (Zoo) ctx.getBean("zoo");
		z.clean();
		
		System.out.println("====Scope ����====");
		
		Dog d01 = (Dog) ctx.getBean("dog01");
		Dog d02 = (Dog) ctx.getBean("dog01");

		//scope �� prototype�̶� �ؽ����� ���� �ٸ��� 
		System.out.println("d01 :"+d01.hashCode());
		System.out.println("d02 :"+d02.hashCode());
		
		Zoo zoo01 = (Zoo) ctx.getBean("zoo01");
		Zoo zoo02 = (Zoo) ctx.getBean("zoo01");
		System.out.println(zoo01+" : "+zoo02);
		
		
		((ClassPathXmlApplicationContext)ctx).destroy();
		
	}
}

package spring.ex03.DI_collection;

import java.util.Iterator;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ex03/DI_collection/bean-collection.xml");
		Company com = (Company)ctx.getBean("company");
		for(Department dept : com.getDepartment()){
			dept.work();
		}
		System.out.println("////////");
		Company com2 = (Company)ctx.getBean("company02");
		for( Department de : com2.getDept().values()){
			de.work();
		}
		System.out.println("/////////");
		Company com3 = (Company)ctx.getBean("company03");
		Iterator keyIter = com3.getP().keySet().iterator();
		while( keyIter.hasNext()){
			String key = (String) keyIter.next();
			String handlerClassName = com3.getP().getProperty(key);
			try {
	            Class<?> handlerClass = Class.forName(handlerClassName);
	            Department d = (Department) handlerClass.newInstance();
	            d.work();
            } catch (ClassNotFoundException e) {
	            e.printStackTrace();
            } catch (InstantiationException e) {
	            e.printStackTrace();
            } catch (IllegalAccessException e) {
	            e.printStackTrace();
            }
		}
	}
}

package spring.ex07.DI_componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestJava {
	public static void main(String args[]){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		MessagePrinter printer = (MessagePrinter)ctx.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}

package spring.ex05.DI_annotation;

import org.springframework.stereotype.Component;

@Component
public class BusinessTeam implements Department{
	public void work(){
		System.out.println("����Ͻ�");
	}
}

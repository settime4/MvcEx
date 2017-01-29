package spring.ex05.DI_annotation;

import org.springframework.stereotype.Component;

//@Component
public class FinancialTeam implements Department{
	public void work(){
		System.out.println("Financial");
	}
}

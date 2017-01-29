package spring.ex06.DI_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	//<bean id="dept01" class="spring.ex06.DI_configuration.BusinessTeam">
	public Department dept01(){
		return new BusinessTeam();
	}
	
	@Bean
	//<bean id="dept02" class="spring.ex06.DI_configuration.BusinessTeam">
	//		<property name="name" value="»ç¾÷ÆÀ">
	public Department dept02(){
		BusinessTeam bt = new BusinessTeam();
		bt.setName("»ç¾÷ÆÀ");
		return bt;
	}
	
	@Bean
	public Employee emp01(){
		Employee e = new Employee();
		e.setDept(new BusinessTeam());
		return e;
	}
	
	@Bean
	public Employee emp02(){
		Employee e = new Employee(new BusinessTeam());
		((BusinessTeam)e.getDept()).setName("»ç¾÷ÆÀ");
		return e;
	}

}

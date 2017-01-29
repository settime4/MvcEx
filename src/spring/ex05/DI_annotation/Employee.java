package spring.ex05.DI_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
//	@Autowired @Qualifier("d01") Department dept;
	Department dept;
	
	@Autowired(required=false) A a;
	
	//@Autowired
	public Employee(Department dept){
		this.dept =dept;
	}
	public Employee() {
    }
	
	@Autowired
	public void play(Department dept){
		this.dept=dept;
		//dept.work();
	}
}

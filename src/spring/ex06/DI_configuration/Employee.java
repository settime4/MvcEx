package spring.ex06.DI_configuration;

public class Employee {
	
	Department dept;
	
	public Employee(Department dept){
		this.dept =dept;
	}
	public Employee() {
    }
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}

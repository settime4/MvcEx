package aaa.rest.ver1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	private String desc;
	private List<Employee> employees = new ArrayList<Employee>();

	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmpoyees(List<Employee> emp) {
		this.employees = emp;
	}
	
	
}

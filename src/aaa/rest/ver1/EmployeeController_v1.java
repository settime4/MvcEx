package aaa.rest.ver1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Controller + @ResponseBody
@RequestMapping("employees")
public class EmployeeController_v1 {

	@RequestMapping(value = "/ver1/{name}.j", produces = "application/json; charset=utf-8")
	public @ResponseBody EmployeeList getEmployeeInJSON(@PathVariable String name) {
		EmployeeList list = new EmployeeList();
		
		list.setDesc("JSON ¡¡æ∆");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail("employee@naver.com");
		list.getEmployees().add(employee);
		Employee employee2 = new Employee();
		employee2.setName(name);
		employee2.setEmail("employee2@naver.com");
		list.getEmployees().add(employee2);
		Employee employee3 = new Employee();
		employee3.setName(name);
		employee3.setEmail("employee3@naver.com");
		list.getEmployees().add(employee3);

		return list;
	}
	
	
	
	@RequestMapping(value="/ver1/showEmpList")
	public String toShowEmpList(){
		
		return "empList";
	}
	
	
}

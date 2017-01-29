package aaa.rest.ver2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("employees")
public class EmployeeController_v2 {

	@RequestMapping(value = "/ver2/{name}.x", produces = "application/xml; charset=utf-8")
	public EmployeeList getEmployeeInXML(@PathVariable String name) {
		EmployeeList list = new EmployeeList();
		
		list.setDesc("XML ¡¡æ∆");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail("employee@naver.com");
		list.getEmployee().add(employee);
		Employee employee2 = new Employee();
		employee2.setName(name);
		employee2.setEmail("employee2@naver.com");
		list.getEmployee().add(employee2);
		Employee employee3 = new Employee();
		employee3.setName(name);
		employee3.setEmail("employee3@naver.com");
		list.getEmployee().add(employee3);

		return list;
	}
}

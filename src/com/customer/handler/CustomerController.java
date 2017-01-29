package com.customer.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import com.utility.Paging;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService = new CustomerService();
	
	@RequestMapping(value="/insert")
	public String insert(@ModelAttribute Customer customer){
		return "insert";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String add(@ModelAttribute Customer customer, Model model){
		int count = customerService.saveCustomer(customer);
		if(count > 0){
			model.addAttribute("msg", "가입 성공");
			model.addAttribute("customer", customer);
			return "result";
		}else{
			model.addAttribute("msg", "가입 실패");
			return "insert";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id, Model model){
		int count = customerService.removeCustomer(id);
		if(count > 0){
			return "redirect:/customer/list";
		}else{
			return "redirect:/customer/list";
		}
	}
	
	@RequestMapping("/list")
	@ModelAttribute("customers")
	public List<Customer> list(){
		List<Customer> list = customerService.getCustomers();
		return list;
	}
	
	@RequestMapping("/page")
	public String page(Model model, @RequestParam(defaultValue="1") int pageNumber, @RequestParam(defaultValue="5") int pageSize){
		List<Customer> list = customerService.getCustomerByPage(pageNumber);
		model.addAttribute("customers", list);
		Paging paging = new Paging(pageNumber, pageSize, customerService.getPageCount());
		model.addAttribute("paging", paging);
		return "list";
	}
	

	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute Customer customer, Model model, @PathVariable int id){
		int count = customerService.modifyCustomer(customer);
		if(count > 0){
			return "redirect:/customer/list"; 
		}else{
			return "update";
		}
	}
	
	@RequestMapping(value="/update/{id}")
	public String update( Model model, @PathVariable int id){
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "update";
	}
	
	@RequestMapping(value="/searchName", method = RequestMethod.POST )
	public String searchCustomerByName(@RequestParam String name, Model model){
		List<Customer> customers = customerService.getCustomerByName(name);
		model.addAttribute("customers", customers);
		return "list";
	}
	
	@RequestMapping("/transaction")
	public String tranCustomer(){
		customerService.transactionTest();
		return "redirect:/customer/list";
	}
}

package com.customer.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.utility.Paging;

@Service
@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
public class CustomerService{
	@Autowired
	@Qualifier("MybatisCustomerRepository")
	//@Qualifier("JdbcDaoSupportProductRepository")
	//@Qualifier("JdbcTemplate_CustomerRepository")
	private CustomerRepository customerRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveCustomer(@ModelAttribute Customer customer){
		return customerRepository.insert(customer);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Customer> getCustomers() {
	    return customerRepository.selectAll();
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public int modifyCustomer(@ModelAttribute Customer customer) {
	    return customerRepository.update(customer);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int removeCustomer(int id){
		return customerRepository.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Customer getCustomerById(int id) {
		return customerRepository.selectById(id);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Customer> getCustomerByName(String name) {
	    return customerRepository.selectByName(name);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int getPageCount(){
		return customerRepository.countPageAll();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Customer> getCustomerByPage(int selectPage){
		List<Customer> customers = customerRepository.selectAll(
				new RowBounds( (selectPage-1)*Paging.getPageSize(), Paging.getPageSize())
				);
		return customers;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void transactionTest(){
		Customer customer = new Customer();
		customer.setName("ddD12222");
		customer.setEmail("email");
		customer.setAddress("d");

		customerRepository.insert(customer);
		
		if(true){
			throw new RuntimeException();
		}
		
		customerRepository.delete(14);
		
	}
}

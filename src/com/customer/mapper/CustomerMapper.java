package com.customer.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.customer.model.Customer;

public interface CustomerMapper {
	public List<Customer> findAll();
	public Customer findById(int id);
	public int save(Customer customer);
	public int modify(Customer customer);
	public int remove(int id);
	public List<Customer> findByName(String name);
	public int countAll();
	public List<Customer> findByPage(RowBounds rowbounds);
}

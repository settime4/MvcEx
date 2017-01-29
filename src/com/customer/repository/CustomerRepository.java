package com.customer.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.customer.model.Customer;

public interface CustomerRepository {
	public int insert(Customer customer);
	public int update(Customer customer);
	public int delete(int id);
	public List<Customer> selectAll();
	public Customer selectById(int id);
	public List<Customer> selectByName(String name);
	public int countPageAll();
	public List<Customer> selectAll(RowBounds rowbounds);
}

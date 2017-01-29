package com.customer.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.mapper.AnnotationCustomerMapper;
import com.customer.mapper.CustomerMapper;
import com.customer.model.Customer;

@Repository("MybatisCustomerRepository")
public class MybatisCustomerRepository implements CustomerRepository {
	//@Autowired private CustomerMapper mapper;
	@Autowired private AnnotationCustomerMapper mapper;

	@Override
    public int insert(Customer customer) {
	    return mapper.save(customer);
    }

	@Override
    public int update(Customer customer) {
	    return mapper.modify(customer);
    }

	@Override
    public int delete(int id) {
	    return mapper.remove(id);
    }

	@Override
    public List<Customer> selectAll() {
	    return mapper.findAll();
    }

	@Override
    public Customer selectById(int id) {
	    return mapper.findById(id);
    }

	@Override
    public List<Customer> selectByName(String name) {
	    return mapper.findByName("%"+name+"%");
    }
	@Override
	public int countPageAll() {
	    return mapper.countAll();
	}
	@Override
	public List<Customer> selectAll(RowBounds rowbounds) {
	    return mapper.findByPage(rowbounds);
	}
}

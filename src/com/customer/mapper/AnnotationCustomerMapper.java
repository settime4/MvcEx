package com.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.customer.model.Customer;

public interface AnnotationCustomerMapper {
	
	@Select("Select * from customers order by id")
	public List<Customer> findAll();
	
	@Select("select * from customers where id=#{id})")
	public Customer findById(int id);
	
	@Insert("insert into customers values(#{id}, #{name}, #{email}, #{address})")
	@SelectKey(statement="select customers_seq.nextval from dual", keyProperty="id", before=true, resultType=int.class)
	public int save(Customer customer);
	
	@Update("update CUSTOMERS set NAME=#{name}, address=#{address}, email=#{email} where id=#{id}")
	public int modify(Customer customer);
	
	@Delete("delete customers where id=#{id}")
	public int remove(int id);
	
	@Select("select * from customers where name like #{name}")
	public List<Customer> findByName(String name);
	
	@Select("select count(*) from customers")
	public int countAll();
	
	@Select("Select * from customers order by id")
	public List<Customer> findByPage(RowBounds rowbounds);
}

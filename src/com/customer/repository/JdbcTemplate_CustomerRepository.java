package com.customer.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

//@Repository("JdbcTemplate_CustomerRepository")
public class JdbcTemplate_CustomerRepository implements CustomerRepository {

	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Customer customer){
		return jdbcTemplate.update(CustomerSql.ex_CUSTOMER_INSERT, customer.getName(), customer.getEmail(), customer.getAddress()  );
	}

	@Override
    public int update(Customer customer) {
	    return jdbcTemplate.update(CustomerSql.ex_CUSTOMER_UPDATE, customer.getName(), customer.getAddress(), customer.getEmail(), customer.getId());
    }

	@Override
    public int delete(int id) {
	    return jdbcTemplate.update(CustomerSql.ex_CUSTOMER_DELETE, id);
    }
	
	@Override
	public List<Customer> selectAll() {
	    return jdbcTemplate.query(CustomerSql.ex_CUSTOMER_SELECT_ALL, new RowMapper<Customer>(){
	    	@Override
	    	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    		Customer customer = new Customer();
	    		customer.setId(rs.getInt("id"));
	    		customer.setAddress(rs.getString("address"));
	    		customer.setEmail(rs.getString("email"));
	    		customer.setName(rs.getString("name"));
	    	    return customer;
	    	}
	    });
	}
	
	@Override
	public Customer selectById(int id) {
		Object[] params = new Object[]{id};
	    return jdbcTemplate.queryForObject(CustomerSql.ex_CUSTOMER_SELECT_ID, params, new RowMapper<Customer>(){
	    	@Override
	    	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    		Customer customer = new Customer();
	    		customer.setId(rs.getInt("id"));
	    		customer.setAddress(rs.getString("address"));
	    		customer.setEmail(rs.getString("email"));
	    		customer.setName(rs.getString("name"));
	    	    return customer;
	    	}
	    });
	}
	
	@Override
	public List<Customer> selectByName(String name) {
		String sql = CustomerSql.ex_CUSTOMER_SELECT_ALL;
        if( ! name.equals("") && name != null){
        	sql += " where name like '%" + name + "%'";
        }
	    
	    return jdbcTemplate.query(sql,  new RowMapper<Customer>(){
	    	@Override
	    	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    		Customer customer = new Customer();
	    		customer.setId(rs.getInt("id"));
	    		customer.setAddress(rs.getString("address"));
	    		customer.setEmail(rs.getString("email"));
	    		customer.setName(rs.getString("name"));
	    	    return customer;
	    	}
	    });
	}
	@Override
	public int countPageAll() {
	    return 0;
	}
	@Override
	public List<Customer> selectAll(RowBounds rowbounds) {
	    return null;
	}
}



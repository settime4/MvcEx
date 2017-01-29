package com.customer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

//@Repository("JdbcDaoSupportProductRepository")
public class JdbcDaoSupportCustomerRepository extends NamedParameterJdbcDaoSupport implements CustomerRepository{
	
	@Autowired public JdbcDaoSupportCustomerRepository(DataSource dataSource) {
		super.setDataSource(dataSource);
    }

	@Override
    public int insert(Customer customer) {
		Map<String, Object > params = new HashMap<String, Object>();
		params.put("name", customer.getName());
		params.put("address", customer.getAddress());
		params.put("email", customer.getEmail());
	    return getNamedParameterJdbcTemplate().update(CustomerSql.CUSTOMER_INSERT, params);
    }

	@Override
    public int update(Customer customer) {
		Map<String, Object > paramMap = new HashMap<String, Object>();
		paramMap.put("name", customer.getName());
		paramMap.put("address", customer.getAddress());
		paramMap.put("email", customer.getEmail());
		paramMap.put("id", customer.getId());
	    return getNamedParameterJdbcTemplate().update(CustomerSql.CUSTOMER_UPDATE, paramMap);
    }

	@Override
    public int delete(int id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
	    return getNamedParameterJdbcTemplate().update(CustomerSql.CUSTOMER_DELETE, paramMap);
    }

	@Override
    public List<Customer> selectAll() {
	    return getNamedParameterJdbcTemplate().query(CustomerSql.CUSTOMER_SELECT_ALL, new RowMapper<Customer>() {
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
	    return getNamedParameterJdbcTemplate().queryForObject(CustomerSql.CUSTOMER_SELECT_ID, paramMap, new RowMapper<Customer>(){
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
		String sql = CustomerSql.CUSTOMER_SELECT_ALL;
        if( ! name.equals("") && name != null){
        	sql += " where name like '%" + name + "%'";
        }
	    return getNamedParameterJdbcTemplate().query(sql,  new RowMapper<Customer>(){
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

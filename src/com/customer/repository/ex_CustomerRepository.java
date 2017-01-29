package com.customer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

//@Repository
public class ex_CustomerRepository {

	@Autowired private DataSource	        dataSource;
	
	private Connection	        connection	    = null;
	private PreparedStatement	pstmt	        = null;
	private ResultSet	        rs	            = null;
	
	private static final String CUSTOEMR_UPDATE = "update CUSTOMERS set NAME=?, address=?, email=? where id=? ";
	private static final String CUSTOEMR_DELETE = "delete CUSTOMERS where id=? ";
	private static final String	CUSTOMER_INSERT	= "insert into customers values(customers_seq.nextval, ?, ?, ?)";
	private static final String	CUSTOMER_SELECT_ALL	= "select * from customers";
	private static final String	CUSTOMER_SELECT	= "select * from customers where id = ?";
	private static final String	CUSTOMER_SEARCH	= "select * from customers ";

	public int insert(Customer customer) {
		int count = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(CUSTOMER_INSERT);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getAddress());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
			}
		}
		return count;
	}

	public List<Customer> selectAll() {
		List<Customer> list = null;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(CUSTOMER_SELECT_ALL);
			rs = pstmt.executeQuery();
			list = new ArrayList<Customer>();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				
				list.add(customer);
			}
		} catch (Exception e) {
		} finally {

			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(connection != null){connection.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public Customer select(int id) {
		Customer customer = null;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(CUSTOMER_SELECT);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
			}
		} catch (Exception e) {
		} finally {

			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(connection != null){connection.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}

	public int update(Customer customer) {
		int count = 0;
		try {
	        connection = dataSource.getConnection();
	        pstmt = connection.prepareStatement(CUSTOEMR_UPDATE);
	        pstmt.setString(1, customer.getName());
	        pstmt.setString(2, customer.getAddress());
	        pstmt.setString(3, customer.getEmail());
	        pstmt.setInt(4, customer.getId());
	        count = pstmt.executeUpdate();
        } catch (Exception e) {
        } finally{
        	try {
        		if(pstmt != null){pstmt.close();}
	            if(connection != null){connection.close();}
            } catch (SQLException e) {
	            e.printStackTrace();
            }
        }
	    return count;
    }

	public int delete(int id) {
		int count = 0;
		try {
	        connection = dataSource.getConnection();
	        pstmt = connection.prepareStatement(CUSTOEMR_DELETE);
	        pstmt.setInt(1, id);
	        count = pstmt.executeUpdate();
        } catch (Exception e) {
        } finally{
        	try {
        		if(pstmt != null){pstmt.close();}
	            if(connection != null){connection.close();}
            } catch (SQLException e) {
	            e.printStackTrace();
            }
        }
	    return count;
    }

	public List<Customer> selectByName(String name) {
		List<Customer> list = null;
		String sql = CUSTOMER_SEARCH;
		try {
	        connection = dataSource.getConnection();
	        if( ! name.equals("") && name != null){
	        	sql += "where name like '%"+name+"%'";
	        	System.out.println(sql);
	        }
	        pstmt = connection.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        list = new ArrayList<Customer>();
	        while(rs.next()){
	        	Customer customer = new Customer();
	        	customer.setId(rs.getInt("id"));
	        	customer.setEmail(rs.getString("email"));
	        	customer.setAddress(rs.getString("address"));
	        	customer.setName(rs.getString("name"));
	        	list.add(customer);
	        }
        } catch (Exception e) {
        } finally{
        	try {
	            if(rs != null){rs.close();}
	            if(pstmt != null){pstmt.close();}
	            if(connection != null){connection.close();}
            } catch (SQLException e) {
	            e.printStackTrace();
            }
        	
        }
	    return list;
    }
	
}

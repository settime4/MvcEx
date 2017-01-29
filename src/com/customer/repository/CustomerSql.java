package com.customer.repository;

public class CustomerSql {

	static final String ex_CUSTOMER_UPDATE = "update CUSTOMERS set NAME=?, address=?, email=? where id=? ";
	static final String ex_CUSTOMER_DELETE = "delete CUSTOMERS where id=? ";
	static final String	ex_CUSTOMER_INSERT	= "insert into customers values(customers_seq.nextval, ?, ?, ?)";
	static final String	ex_CUSTOMER_SELECT_ALL	= "select * from customers";
	static final String	ex_CUSTOMER_SELECT_ID	= "select * from customers where id = ?";
		
	static final String CUSTOMER_UPDATE = "update CUSTOMERS set NAME=:name, address=:address, email=:email where id=:id ";
	static final String CUSTOMER_DELETE = "delete CUSTOMERS where id=:id ";
	static final String	CUSTOMER_INSERT	= "insert into customers values(customers_seq.nextval, :name, :email, :address)";
	static final String	CUSTOMER_SELECT_ALL	= "select * from customers";
	static final String	CUSTOMER_SELECT_ID	= "select * from customers where id = :id";
	static final String	CUSTOMER_SELECT_NAME	= "select * from customers where name like '%:name%'";
}

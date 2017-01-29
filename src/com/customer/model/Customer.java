package com.customer.model;


public class Customer {
	private int id;
	private String name, address, email;
	
	@Override
    public String toString() {
	    return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

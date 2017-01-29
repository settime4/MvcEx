package abc.shopping.dto;

public class Customer {
	long id;
	String name, address, email;
	
	@Override
    public String toString() {
	    return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
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

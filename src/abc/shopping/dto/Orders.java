package abc.shopping.dto;

import java.util.List;

public class Orders {
	long id;
	String order_date;
	Customer customer;
	List<OrderItem> items;
	
	
	@Override
    public String toString() {
	    return "Orders [id=" + id + ", order_date=" + order_date + ", customer=" + customer + ", items=" + items + "]";
    }
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
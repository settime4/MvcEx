package abc.shopping.mapper;

import java.util.List;

import abc.shopping.dto.Customer;
import abc.shopping.dto.OrderItem;
import abc.shopping.dto.Orders;



public interface ShoppingMapper {

	
	OrderItem findByOrderItemId(long id);
		
	Orders findByOrderId(long id);
	
	OrderItem findByOrderIdFromOrderItem(long id);
	
	List<Customer> find(Customer customer);
}

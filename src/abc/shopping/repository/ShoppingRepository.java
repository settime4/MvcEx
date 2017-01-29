package abc.shopping.repository;

import java.util.List;

import abc.shopping.dto.Customer;
import abc.shopping.dto.OrderItem;
import abc.shopping.dto.Orders;
import abc.shopping.dto.Product;

public interface ShoppingRepository {
	//OrderItemProduct searchByOrderItemId(long id);

	OrderItem findByOrderItemId(long id);
	Orders findByOrderId(long id);
	List<Customer> find(Customer customer);
	int insertCustomer(Customer customer);
	int insertProduct(Product product);
	int insertOrder(Orders order);
	int insertOrderItem(OrderItem orderItem);
	List<Product> selectAllProduct();
}

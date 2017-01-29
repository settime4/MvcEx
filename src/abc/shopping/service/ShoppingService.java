package abc.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import abc.shopping.dto.Customer;
import abc.shopping.dto.OrderItem;
import abc.shopping.dto.Orders;
import abc.shopping.dto.Product;
import abc.shopping.repository.ShoppingRepository;


@Service
public class ShoppingService{
	@Autowired
	@Qualifier("MybatisShoppingRepository")
	private ShoppingRepository shoppingRepository;
	
/*	public OrderItemProduct searchByOrderItemId(long id){
		return shoppingRepository.searchByOrderItemId(id);
	}*/
	public List<Product> selectAllProduct(){
		return shoppingRepository.selectAllProduct();
	}
	
	public OrderItem findByOrderItemId(long id){
		return shoppingRepository.findByOrderItemId(id);
	}

	public Orders findByOrderId(long id) {
	    return shoppingRepository.findByOrderId(id);
    }

	public List<Customer> find(Customer customer) {
	    return shoppingRepository.find(customer);
    }

	public int insertCustomer(Customer customer) {
	    return shoppingRepository.insertCustomer(customer);
    }
	
	public int insertProduct(Product product){
		return shoppingRepository.insertProduct(product);
	}
	public int insertOrder(Orders orders){
		return shoppingRepository.insertOrder(orders);
	}
	public int insertOrderItem(OrderItem orderItem){
		return shoppingRepository.insertOrderItem(orderItem);
	}
}

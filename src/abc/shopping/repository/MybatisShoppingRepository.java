package abc.shopping.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.shopping.dto.Customer;
import abc.shopping.dto.OrderItem;
import abc.shopping.dto.Orders;
import abc.shopping.dto.Product;
import abc.shopping.mapper.AnnotationShoppingMapper;


@Repository("MybatisShoppingRepository")
public class MybatisShoppingRepository implements ShoppingRepository {
	//@Autowired private ShoppingMapper_ex mapper;
	//@Autowired private ShoppingMapper mapper;
	@Autowired private AnnotationShoppingMapper mapper;

	/*@Override
    public OrderItemProduct searchByOrderItemId(long id) {
	    return mapper.searchByOrderItemId(id);
    }*/

	@Override
	public OrderItem findByOrderItemId(long id) {
	    return mapper.findByOrderItemId(id);
	}
	
	
	@Override
	public Orders findByOrderId(long id) {
	    return mapper.findByOrderId(id);
	}

	@Override
	public List<Customer> find(Customer customer) {
	    return mapper.find(customer);
	}


	@Override
    public int insertCustomer(Customer customer) {
	    return mapper.insertCustomer(customer);
    }


	@Override
    public int insertProduct(Product product) {
	    return mapper.insertProduct(product);
    }


	@Override
    public int insertOrder(Orders order) {
	    return mapper.insertOrder(order);
    }


	@Override
    public int insertOrderItem(OrderItem orderItem) {
	    return mapper.insertOrderItem(orderItem);
    }
	
	@Override
	public List<Product> selectAllProduct() {
	    return mapper.selectAllProduct();
	}
}

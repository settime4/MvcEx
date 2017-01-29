package abc.shopping.mapper;

import org.apache.ibatis.annotations.Select;

import abc.shopping.dto.OrderItem_ex;
import abc.shopping.dto.OrderItemProduct;
import abc.shopping.dto.Product;



public interface ShoppingMapper_ex {

	@Select("select product_id as id, name, price, description from product where id=#{id}")
	Product findByProductId(long id);
	
	@Select("select p.name, p.price, oi.amount from product p inner join orderitem oi on oi.product_id = p.product_id where oi.ORDERITEM_ID=#{id}")
	OrderItemProduct findByOrderItemId(long id);
	
}

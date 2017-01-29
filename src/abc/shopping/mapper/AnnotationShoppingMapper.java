package abc.shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import abc.shopping.dto.Customer;
import abc.shopping.dto.OrderItem;
import abc.shopping.dto.Orders;
import abc.shopping.dto.Product;



public interface AnnotationShoppingMapper {
	
	
	@Select("select orderitem_id, amount, order_id, product_id from orderitem where orderitem_id=#{id}")
	@Results({
		@Result(id=true, property="id", column="orderitem_id"),
		@Result(property="amount", column="amount"),
		@Result(property="product", column="product_id", one=@One(select="findByProductId"))
	})
	OrderItem findByOrderItemId(long id);
	
	
	@Select("select * from orderitem where order_id=#{id}")
	@Results({
		@Result(id=true, property="id", column="orderitem_id"),
		@Result(property="amount", column="amount"),
		@Result(property="product", column="product_id", one=@One(select="findByProductId"))
	})
	List<OrderItem> findByOrderIdFromOrderItem(long id);
	
	
	
	
	@Select("select order_id, to_char(ORDER_DATE, 'yy-MM-dd') as order_date, customer_id from orders where order_id=#{id}")
	@Results({
		@Result(id=true, property="id", column="order_id"),
		@Result(property="order_date", column="order_date"),
		@Result(property="customer", column="customer_id", one=@One(select="findByCustomerId")),
		@Result(property="items", column="order_id", many=@Many(select="findByOrderIdFromOrderItem"))
	})
	Orders findByOrderId(long id);
	
	
	
	
	@Select("select product_id as id, name, price, description from product where product_id=#{id}")
	Product findByProductId(long id);
	
	@Select("select * from product")
	List<Product> selectAllProduct();
	
	@Select("select customer_id as id, name, address, email from customer where	customer_id=#{id}")
	Customer findByCustomerId(long id);
	
	@SelectProvider(type=CustomerSqlProvider.class, method="find")
	List<Customer> find(Customer customer);
	
	@Insert("insert into customer values(#{id}, #{name}, #{address}, #{email} )")
	@SelectKey(statement="select customer_seq.nextval from dual", keyProperty="id", before=true, resultType=long.class)
	int insertCustomer(Customer customer);
	
	@Insert("insert into product values(#{id}, #{name}, #{price}, #{description})")
	@SelectKey(statement="select product_seq.nextval from dual", keyProperty="id", before=true, resultType=long.class)
	int insertProduct(Product product);
	
	@Insert("insert into orders values(#{id}, #{order_date}, #{customer_id})")
	@SelectKey(statement="select orders_seq.nextval from dual", keyProperty="id", before=true, resultType=long.class)
	int insertOrder(Orders orders);
	
	@Insert("insert into orderitem values(#{id}, #{amount}, #{order_id}, #{product_id})")
	@SelectKey(statement="select orderitem_seq.nextval from dual", keyProperty="id", before=true, resultType=long.class)
	int insertOrderItem(OrderItem orderItem);
}

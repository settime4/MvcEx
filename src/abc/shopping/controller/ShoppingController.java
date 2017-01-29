package abc.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import abc.shopping.condition.OrderCondition;
import abc.shopping.condition.OrderItemCondition;
import abc.shopping.dto.Customer;
import abc.shopping.dto.OrderItem;
import abc.shopping.dto.Orders;
import abc.shopping.dto.Product;
import abc.shopping.service.ShoppingService;


@Controller
public class ShoppingController {
	@Autowired ShoppingService shoppingService= new ShoppingService();
	
	@RequestMapping("/searchOrderItem")
	public String searchOrderItemForm(@ModelAttribute OrderItemCondition orderItemCondition){
		return "searchOrderItem";
	}
	
	@RequestMapping("searchOrder")
	public String searchOrderForm(@ModelAttribute OrderCondition orderCondition){
		return "searchOrder";
	}
	
	@RequestMapping("/searchCustomer")
	public String searchCustomerForm(@ModelAttribute Customer customer){
		return "searchCustomer";
	}
	
	@RequestMapping(value="/searchOrderItem", method=RequestMethod.POST)
	public String searchOrderItem(@ModelAttribute OrderItemCondition orderItemCondition, Model model){
		//OrderItemProduct oip = shoppingService.searchByOrderItemId(orderItemCondition.getId());
		OrderItem oip = shoppingService.findByOrderItemId(orderItemCondition.getId());
		System.out.println(oip.toString());
		model.addAttribute("oip", oip);
		return "orderItem";
	}
	
	@RequestMapping(value="searchOrder", method=RequestMethod.POST)
	public String searchOrder(@ModelAttribute OrderCondition orderCondition, Model model){
		Orders order = shoppingService.findByOrderId(orderCondition.getId());
		System.out.println(order.toString());
		model.addAttribute("order", order);
		return "orders";
	}
	
	@RequestMapping(value="/searchCustomer", method=RequestMethod.POST)
	public String searchCustomerForm(@ModelAttribute Customer customer, Model model){
		List<Customer> customers = shoppingService.find(customer);
		model.addAttribute("customers", customers);
		return "customer";
	}
	
	@RequestMapping(value="/insertCustomer")
	public String insertCustomerForm(@ModelAttribute Customer customer){
		return "insertCustomer";
	}
	
	@RequestMapping(value="/insertCustomer", method = RequestMethod.POST)
	public String insertCustomer(@ModelAttribute Customer customer, Model model){
		int count = shoppingService.insertCustomer(customer);
		if(count > 0){
			model.addAttribute("msg", "가입 성공");
			model.addAttribute("customer", customer);
			return "insertCustomerResult";
		}else{
			model.addAttribute("msg", "가입 실패");
			return "insertCustomer";
		}
	}
	
	@RequestMapping(value="/insertProduct")
	public String insertProductForm(@ModelAttribute Product product){
		return "insertProduct";
	}
	
	@RequestMapping(value="/insertProduct", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute Product product, Model model){
		int count = shoppingService.insertProduct(product);
		if(count > 0){
			model.addAttribute("msg", "상품등록 성공");
			model.addAttribute("product", product);
			return "insertProductResult";
		}else{
			model.addAttribute("msg", "상품등록 실패");
			return "insertProduct";
		}
	}
	@RequestMapping(value="/insertOrder")
	public String insertOrderForm(Model model){
		List<Product> products = shoppingService.selectAllProduct();
		model.addAttribute("products", products);
		return "insertOrder";
	}
	
	@RequestMapping(value="/insertOrder", method = RequestMethod.POST)
	public String insertOrder(Orders orders, Model model){
		int countOrder = shoppingService.insertOrder(orders);
		
		if(countOrder > 0 ){
			model.addAttribute("msg", "주문 성공");
			model.addAttribute("order", orders);
			return "orders";
		}else{
			model.addAttribute("msg", "상품등록 실패");
			return "insertOrderResult";
		}
	}
	
	
}

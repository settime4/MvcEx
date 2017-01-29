package abc.shopping.dto;

public class OrderItem_ex {
	long id, order_id, amount, product_id;

	
	
	@Override
    public String toString() {
	    return "OrderItem_ex [id=" + id + ", order_id=" + order_id + ", amount=" + amount + ", product_id=" + product_id + "]";
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	

	
}

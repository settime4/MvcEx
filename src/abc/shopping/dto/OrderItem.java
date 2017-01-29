package abc.shopping.dto;

public class OrderItem {
	long id,  amount;
	Product product;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
    public String toString() {
	    return "OrderItem [id=" + id + ", amount=" + amount + ", product=" + product + "]";
    }

	

	
}

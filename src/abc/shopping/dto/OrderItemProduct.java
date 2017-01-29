package abc.shopping.dto;

public class OrderItemProduct {
	String name;
	long price, amount;
	
	
	@Override
    public String toString() {
	    return "OrderItemProduct [name=" + name + ", price=" + price + ", amount=" + amount + "]";
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
}

package abc.shopping.dto;

public class Product {
	long id, price;
	String name, description;
	
	
	
	@Override
    public String toString() {
	    return "Product [id=" + id + ", price=" + price + ", name=" + name + ", description=" + description + "]";
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}


public class Product {
	private String ID ;
	private String name ;
	private String quantity;
	private String brand;
	private String salePerOne;
	private String costPerOne;
	private String category;
	private String DepID ;
	
	public Product() {
		super();
	}
	
	
	
	
	public Product(String iD, String name, String quantity, String brand, String salePerOne, String catogry,
			String depID) {
		super();
		ID = iD;
		this.name = name;
		this.quantity = quantity;
		this.brand = brand;
		this.salePerOne = salePerOne;
		this.category = catogry;
		DepID = depID;
	}




	public Product(String iD, String name, String quantity, String brand, String salePerOne, String costPerOne, String catogry,
			String depID) {
		super();
		ID = iD;
		this.name = name;
		this.quantity = quantity;
		this.brand = brand;
		this.salePerOne = salePerOne;
		this.costPerOne = costPerOne;
		this.category = catogry;
		DepID = depID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSalePerOne() {
		return salePerOne;
	}
	public void setSalePerOne(String salePerOne) {
		this.salePerOne = salePerOne;
	}
	public String getCostPerOne() {
		return costPerOne;
	}
	public void setCostPerOne(String costPerOne) {
		this.costPerOne = costPerOne;
	}
	
	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getDepID() {
		return DepID;
	}
	public void setDepID(String depID) {
		DepID = depID;
	}
	




	@Override
	public String toString() {
		return ID + "," + name + "," + quantity + "," + brand + ","+ salePerOne +
				 "," + category + "," + DepID ;
	}
	
	
	

}

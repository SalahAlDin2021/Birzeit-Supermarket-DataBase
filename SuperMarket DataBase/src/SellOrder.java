
public class SellOrder {
	private String ID;
	private String customerID;
	private String productID;
	private String date;
	private String totalPrice ;
	
	
	
	public SellOrder(String iD, String customerID, String productID, String date, String totalPrice) {
		super();
		ID = iD;
		this.customerID = customerID;
		this.productID = productID;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	public SellOrder(String iD, String customerID, String date, String totalPrice) {
		super();
		ID = iD;
		customerID = customerID;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	public SellOrder(String iD, String customerID, String date) {
		super();
		ID = iD;
		customerID = customerID;
		this.date = date;
	}
	public SellOrder() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSaleID() {
		return customerID;
	}
	public void setSaleID(String customerID) {
		customerID = customerID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	
	
	
	
	
	
	

}

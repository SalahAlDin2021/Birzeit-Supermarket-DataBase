import java.sql.Date;

public class BuyOrder {
	private String ID;
	private String supplierID;
	private String productID;
	private String date;
	private String totalPrice ;
	
	
	public BuyOrder(String iD, String supplierID, String productID, String date, String totalPrice) {
		super();
		ID = iD;
		this.supplierID = supplierID;
		this.productID = productID;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	public BuyOrder(String iD, String supplierID, String date, String totalPrice) {
		super();
		ID = iD;
		supplierID = supplierID;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	public BuyOrder(String iD, String supplierID, String date) {
		super();
		ID = iD;
		supplierID = supplierID;
		this.date = date;
	}
	public BuyOrder() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSaleID() {
		return supplierID;
	}
	public void setSaleID(String supplierID) {
		supplierID = supplierID;
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
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	
	

}


public class Supplier {
	private String ID;
	private String name;
	private String city;
	
	
	
	public Supplier() {
		super();
	}



	public Supplier(String iD, String name, String city) {
		super();
		ID = iD;
		this.name = name;
		this.city = city;
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



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}
	
	


	
	

}

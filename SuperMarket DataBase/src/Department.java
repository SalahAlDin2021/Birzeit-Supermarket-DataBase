
public class Department {
	private String ID ;
	private String name ;
	private String city;
	private String managerID;
	
	
	
	public Department() {
		super();
	}
	public Department(String iD, String name, String city, String managerID) {
		super();
		ID = iD;
		this.name = name;
		this.city = city;
		this.managerID = managerID;
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
	public String getManager() {
		return managerID;
	}
	public void setManager(String managerID) {
		this.managerID = managerID;
	}
	

}

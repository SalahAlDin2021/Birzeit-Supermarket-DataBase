
public class Customer {

	private String ID;
	private String name;
	private String phone;
	private String gender;
	private String city;
	private String password;
	public Customer() {
		super();
	}
	public Customer(String iD, String name, String phone, String gender, String city, String password) {
		super();
		ID = iD;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

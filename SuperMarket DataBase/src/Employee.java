
public class Employee {
	private String ID ;
	private String DepID ;
	private String name ;
	private String gender ;
	private String DOB;
	private String HDate;
	private String FDate;
	private String phone;
	private String city;
	private String password;
	private String salary;
	
	
	
	public Employee() {
		super();
	}
	
	
	
	public Employee(String iD, String depID, String name, String gender, String dOB, String hDate, String fDate,
			String phone, String city, String password, String salary) {
		super();
		ID = iD;
		DepID = depID;
		this.name = name;
		this.gender = gender;
		DOB = dOB;
		HDate = hDate;
		FDate = fDate;
		this.phone = phone;
		this.city = city;
		this.password = password;
		this.salary = salary;
	}



	public Employee(String iD, String depID, String name, String gender, String dOB, String hDate, String phone, String city,
			String password,String salary) {
		super();
		ID = iD;
		DepID = depID;
		this.name = name;
		this.gender = gender;
		DOB = dOB;
		HDate = hDate;
		this.phone = phone;
		this.city = city;
		this.password = password;
		this.salary = salary;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDepID() {
		return DepID;
	}
	public void setDepID(String depID) {
		DepID = depID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getHDate() {
		return HDate;
	}
	public void setHDate(String hDate) {
		HDate = hDate;
	}
	public String getFDate() {
		return FDate;
	}
	public void setFDate(String fDate) {
		FDate = fDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	

}


public class Childrens {
	private String childID;
	private String empID;
	private String name;
	private String DOB;
	private String gender;
	
	public Childrens() {
		super();
	}
	
	
	
	public Childrens(String childID, String empID) {
		super();
		this.childID = childID;
		this.empID = empID;
	}



	public Childrens(String childID, String empID, String name, String dOB, String gender) {
		super();
		this.childID = childID;
		this.empID = empID;
		this.name = name;
		DOB = dOB;
		this.gender = gender;
	}



	public String getChildID() {
		return childID;
	}



	public void setChildID(String childID) {
		this.childID = childID;
	}



	public String getEmpID() {
		return empID;
	}



	public void setEmpID(String empID) {
		this.empID = empID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDOB() {
		return DOB;
	}



	public void setDOB(String dOB) {
		DOB = dOB;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}

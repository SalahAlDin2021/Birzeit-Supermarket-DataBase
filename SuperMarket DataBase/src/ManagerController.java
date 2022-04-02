import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManagerController implements Initializable{
	
	@FXML
	private TextField productid10 ;
	
	@FXML
	private TextField productname10 ;
	
	@FXML
	private TextField departmentid10 ;
	
	@FXML
	private TextField category10 ;
	
	@FXML
	private TextField brand10 ;
	
	@FXML
	private TextField costperone10 ;
	
	@FXML
	private TextField saleperone10 ;
	
	
	
	@FXML
	private TextField suppidtxt1 ;
	
	@FXML
	private TextField orderidtxt1 ;
	
	@FXML
	private TextField prodidtxt ;
	
	@FXML
	private TextField quantity ;
	
	
	//add employee texts
	@FXML
	private TextField emppid1 ;
	@FXML
	private TextField emppname1 ;
	@FXML
	private TextField emppphone1 ;
	@FXML
	private TextField emppgender1 ;
	@FXML
	private TextField emppcity1 ;
	@FXML
	private TextField empppass1 ;
	@FXML
	private TextField emppdate1 ;
	@FXML
	private TextField emppdepid1 ;
	@FXML
	private TextField emppsalary1 ;
	
	
	
	
	@FXML
    private TableView<Employee> employeeTable;
	
    @FXML
    private TableColumn<Employee, String> col_employeeid11;
    @FXML
    private TableColumn<Employee, String> col_employeename11;
    @FXML
    private TableColumn<Employee, String> col_phone11;
    @FXML
    private TableColumn<Employee, String> col_gender11;
    @FXML
    private TableColumn<Employee, String> col_city11;
    @FXML
    private TableColumn<Employee, String> col_password111;
    @FXML
    private TableColumn<Employee, String> col_hire11;
    @FXML
    private TableColumn<Employee, String> col_fire11;
    @FXML
    private TableColumn<Employee, String> col_dob11;
    @FXML
    private TableColumn<Employee, String> col_depid11;
    @FXML
    private TableColumn<Employee, String> col_salary11;
    
    
	@FXML
    private TableView<Product> productTable;
	
    @FXML
    private TableColumn<Product, String> col_prodid;
    @FXML
    private TableColumn<Product, String> col_prodname;
    @FXML
    private TableColumn<Product, String> col_depid;
    @FXML
    private TableColumn<Product, String> col_category;
    @FXML
    private TableColumn<Product, String> col_brand;
    @FXML
    private TableColumn<Product, String> col_cost;
    @FXML
    private TableColumn<Product, String> col_quantity;
    
    @FXML
    private TableView<BuyOrder> orderTable;
	
    @FXML
    private TableColumn<BuyOrder, String> col_orderid;
    @FXML
    private TableColumn<BuyOrder, String> col_suppid;
    @FXML
    private TableColumn<BuyOrder, String> col_date;
    @FXML
    private TableColumn<BuyOrder, String> col_totalprice;
    @FXML
    private TableColumn<BuyOrder, String> col_productid;
    
    @FXML
    private TableView<Customer> customerTable;
	
    @FXML
    private TableColumn<Customer, String> col_customerid1;
    @FXML
    private TableColumn<Customer, String> col_customername1;
    @FXML
    private TableColumn<Customer, String> col_phone1;
    @FXML
    private TableColumn<Customer, String> col_gender1;
    @FXML
    private TableColumn<Customer, String> col_city1;
    @FXML
    private TableColumn<Customer, String> col_password11;
    
    @FXML
    private TableView<Supplier> supplierTable;
	
    @FXML
    private TableColumn<Supplier, String> col_supplierid2;
    @FXML
    private TableColumn<Supplier, String> col_suppliername2;
    @FXML
    private TableColumn<Supplier, String> col_city2;
    
    @FXML
    private TextField prevpassword;

    @FXML
    private TextField newpassword;
    
    ObservableList<Product>oblist=FXCollections.observableArrayList();
    
    
	ObservableList<BuyOrder>oblist2=FXCollections.observableArrayList();
	ObservableList<Customer>oblist3=FXCollections.observableArrayList();
	ObservableList<Supplier>oblist4=FXCollections.observableArrayList();
	ObservableList<Employee>oblist5=FXCollections.observableArrayList();
    
    
    public  void ADD(ActionEvent event) throws Exception {
    	
    	Connection conn = DBConnecter.getConnection();
    	
    	String sql ="INSERT INTO `supermarket`.`product` (`Product_id`, `Product_name`, `quantity`, `brand`,"
    			+ " `costPricePerOne`, `SALEPricePerOne`, `category`, `department_id`) VALUES "
    			+ "('"+productid10.getText()+"', '"+productname10.getText()+"', '"+0+"', '"+brand10.getText()+"',"
    					+ " '"+costperone10.getText()+"',"+ " '"+saleperone10.getText()+"', '"+category10.getText()
    					+"', '"+departmentid10.getText()+"')";

    	Statement st = conn.createStatement();
		boolean result3 = st.execute(sql);
		JOptionPane.showMessageDialog(null, "We Have New Product");
    	
    	
    	
    	
    	
    }
    
    
    
    
public  void Buy(ActionEvent event) throws Exception {
    	
    	java.util.Date dt = new java.util.Date();
    	java.text.SimpleDateFormat sdf = 
    	     new java.text.SimpleDateFormat("yyyy-MM-dd");
    	String currentTime = sdf.format(dt);

    	Connection conn = DBConnecter.getConnection();
    	String getTotalprice = "SELECT * FROM supermarket.product where product_id = '"+prodidtxt.getText()+"' ";
    	Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(getTotalprice);
    	if (result.next()) {
			Connection conn2 = DBConnecter.getConnection();
	    	String getSupplier = "SELECT * FROM supermarket.supplier where sup_id = '"+suppidtxt1.getText()+"' ";
	    	Statement st2 = conn.createStatement();
			result = st.executeQuery(getTotalprice);
			if(result.next()) {
				String costPrice = result.getString("costPricePerOne");
				String totalQuantity = result.getString("quantity");
				int totalquant = Integer.parseInt(totalQuantity) ;
				int quantity2 = Integer.parseInt(quantity.getText()) ;
				double costPrice2 = Double.parseDouble(costPrice);
				double totalPrice =  costPrice2 * quantity2 ;
				Connection conn3 = DBConnecter.getConnection();
				String sql3 ="INSERT INTO `supermarket`.`buyorder`"
						+ " (`Order_id`, `supplier_id`, `Date`, `totalPrice`, `product_id`) VALUES"
						+ " ('"+orderidtxt1.getText()+"', '"+suppidtxt1.getText()+"', '"+currentTime+"', '"+totalPrice+"'"
								+ ", '"+prodidtxt.getText()+"')";
				st = conn2.createStatement();
				boolean result3 = st.execute(sql3);
				Connection conn4 = DBConnecter.getConnection();
				String sql4 = "UPDATE `supermarket`.`product` SET `quantity` = '"+(totalquant+quantity2)+"'"
						+ " WHERE (`Product_id` = '"+prodidtxt.getText()+"')";
				 st = conn4.createStatement();
				 boolean result4 = st.execute(sql4);
				 JOptionPane.showMessageDialog(null, "you are buy "+quantity.getText()+
						 " product with cost +"+totalPrice);

				
			}else {
				JOptionPane.showMessageDialog(null, "No Enough products");
			} 
			
		}else {
			JOptionPane.showMessageDialog(null, "there is an error");
		}
    	
    	
    }
    
    
	
	
	
    public  void change(ActionEvent event) throws Exception {
    	Connection conn = DBConnecter.getConnection();
		String sql = "select * from supermarket.employee where Emp_id= '" +LoginController.ID + "'";
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		if (result.next()) {
			String pass = result.getString(6);
			if ( prevpassword.getText().equals(pass)) {
				String sql2 = "UPDATE `supermarket`.`employee` SET `password` = '"
			+newpassword.getText()+"'"+ " WHERE (`Emp_id` = '"+LoginController.ID +"')";
				Connection conn2 = DBConnecter.getConnection();
				 st = conn2.createStatement();
				 int result2 = st.executeUpdate(sql2);
				  System.out.println("hi"); 
				  System.out.println("sucsess");
				  JOptionPane.showMessageDialog(null, "Change Sucsess");
			}else {
				JOptionPane.showMessageDialog(null, "the username or passward is incorrect");
			}
		}else {
			JOptionPane.showMessageDialog(null, "there is an error");
		}
    	
    	
    }
    
    
    public void ProdTable() {

    	col_prodid.setCellValueFactory(new PropertyValueFactory<>("ID"));
		col_prodname.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_depid.setCellValueFactory(new PropertyValueFactory<>("DepID"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("category"));
		col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
		col_cost.setCellValueFactory(new PropertyValueFactory<>("salePerOne"));
		col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		oblist = DBConnecter.getDataproduct();
		productTable.setItems(oblist);

	}
    
    
    
    public void orderTable() {

    	col_orderid.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	col_suppid.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
    	col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    	col_totalprice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
    	col_productid.setCellValueFactory(new PropertyValueFactory<>("productID"));
		oblist2 = DBConnecter.getDataBuyOrder();
		orderTable.setItems(oblist2);

	}
    
   public void customerTable() {

	   col_customerid1.setCellValueFactory(new PropertyValueFactory<>("ID"));
	   col_customername1.setCellValueFactory(new PropertyValueFactory<>("name"));
	   col_phone1.setCellValueFactory(new PropertyValueFactory<>("phone"));
	   col_gender1.setCellValueFactory(new PropertyValueFactory<>("gender"));
	   col_city1.setCellValueFactory(new PropertyValueFactory<>("city"));
	   col_password11.setCellValueFactory(new PropertyValueFactory<>("password"));
		oblist3 = DBConnecter.getDataCustomer();
		customerTable.setItems(oblist3);

	}
   
  public void supplierTable() {

	  col_supplierid2.setCellValueFactory(new PropertyValueFactory<>("ID"));
	  col_suppliername2.setCellValueFactory(new PropertyValueFactory<>("name"));
	  col_city2.setCellValueFactory(new PropertyValueFactory<>("city"));
		oblist4 = DBConnecter.getDataSupplier();
		supplierTable.setItems(oblist4);

	}
  
  public void EmployeeTable() {

	  col_employeeid11.setCellValueFactory(new PropertyValueFactory<>("ID"));
	  col_employeename11.setCellValueFactory(new PropertyValueFactory<>("name"));
	  col_phone11.setCellValueFactory(new PropertyValueFactory<>("phone"));
	  col_gender11.setCellValueFactory(new PropertyValueFactory<>("gender"));
	  col_city11.setCellValueFactory(new PropertyValueFactory<>("city"));
	  col_password111.setCellValueFactory(new PropertyValueFactory<>("password"));
	  col_hire11.setCellValueFactory(new PropertyValueFactory<>("HDate"));
	  col_fire11.setCellValueFactory(new PropertyValueFactory<>("FDate"));
	  col_dob11.setCellValueFactory(new PropertyValueFactory<>("DOB"));
	  col_depid11.setCellValueFactory(new PropertyValueFactory<>("DepID"));
	  col_salary11.setCellValueFactory(new PropertyValueFactory<>("salary"));
		oblist5 = DBConnecter.getDataEmployee();
		employeeTable.setItems(oblist5);

	}
    
  public  void ADDEmp(ActionEvent event) throws Exception {
	  java.util.Date dt = new java.util.Date();
  	java.text.SimpleDateFormat sdf = 
  	     new java.text.SimpleDateFormat("yyyy-MM-dd");
  	String currentTime = sdf.format(dt);
	    	Connection conn = DBConnecter.getConnection();
	    	String sql ="INSERT INTO `supermarket`.`employee` (`Emp_id`, `Emp_name`, `Gender`,"
	    			+ " `hiredate`, `dateOfBirth`, `phone`, `Dep_id`, `city`, `password`, `Salary`) VALUES"
	    			+ " ('"+emppid1.getText()+"', '"+emppname1.getText()+"', '"+emppgender1.getText()+"',"+ " '"+currentTime
	    			+"', '"+emppdate1.getText()+"',"+ " '"+emppphone1.getText()+"', '"+emppdepid1.getText()
	    			+"', '"+emppcity1.getText()+"', '"+empppass1.getText()+"', '"+emppsalary1.getText()+"')";


	    	Statement st = conn.createStatement();
			boolean result3 = st.execute(sql);
			JOptionPane.showMessageDialog(null, "We Have New Employee");
	    	
	    }
  @FXML
  TextField custid ;
  public  void DeleteCustomer(ActionEvent event) throws Exception {
	  Connection conn = DBConnecter.getConnection();
  	String sql ="DELETE FROM `supermarket`.`customer` WHERE (`customer_id` = '"+custid.getText()+"')" ;

  	Statement st = conn.createStatement();
		boolean result3 = st.execute(sql);
		JOptionPane.showMessageDialog(null, "the Customer Was Deleted"); 
	  
  }
  
  
  
  public  void refresh1(ActionEvent event) throws Exception {
		EmployeeTable();
  }
  
  public  void refresh2(ActionEvent event) throws Exception {
	  ProdTable();
}
  
  public  void refresh3(ActionEvent event) throws Exception {
	  orderTable();
}
  
  public  void refresh4(ActionEvent event) throws Exception {
	  customerTable();
}
  
  public  void refresh5(ActionEvent event) throws Exception {
	  supplierTable();
}
  
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		supplierTable();
		customerTable();
		orderTable();
		ProdTable();
		EmployeeTable();
	}

}

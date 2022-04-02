import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class CustomerController implements Initializable{
	
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
    private TextField orderidtxt;
    
    @FXML
    private TextField idtxt;

    @FXML
    private TextField quantity;
    
    @FXML
    private TableView<SellOrder> orderTable;
    @FXML
    private TableColumn<SellOrder, String> col_orderid;

    @FXML
    private TableColumn<SellOrder, String> col_customerid;

    @FXML
    private TableColumn<SellOrder, String> col_date;

    @FXML
    private TableColumn<SellOrder, String> col_totalprice;

    @FXML
    private TableColumn<SellOrder, String> col_productid;
    
    @FXML
    private TextField prevpassword;

    @FXML
    private TextField newpassword;
    
    ObservableList<Product>oblist=FXCollections.observableArrayList();
    
    
	ObservableList<SellOrder>oblist2=FXCollections.observableArrayList();
    
    
    
    public  void Buy(ActionEvent event) throws Exception {
    	
    	java.util.Date dt = new java.util.Date();
    	java.text.SimpleDateFormat sdf = 
    	     new java.text.SimpleDateFormat("yyyy-MM-dd");
    	String currentTime = sdf.format(dt);

    	Connection conn = DBConnecter.getConnection();
    	String getTotalprice = "SELECT * FROM supermarket.product where product_id = '"+idtxt.getText()+"' ";
    	Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(getTotalprice);
    	if (result.next()) {
			String salePrice = result.getString("SALEPricePerOne");
			String totalQuantity = result.getString("quantity");
			int quantity2 = Integer.parseInt(quantity.getText()) ;
			int totalquant = Integer.parseInt(totalQuantity) ;
			if(totalquant > quantity2) {
				int totalprice = Integer.parseInt(quantity.getText()) * Integer.parseInt(salePrice);
				Connection conn2 = DBConnecter.getConnection();
				String sql1 = "INSERT INTO `supermarket`.`sellorder`"
						+ " (`Order_id`, `customer_id`, `Date`, `TotalPrice`, `product_id`)"
						+ " VALUES ('"+orderidtxt.getText()+"', '"+LoginController.ID+"', '"+currentTime+
						"', '"+totalprice+"', '"+idtxt.getText()+"')";
				st = conn2.createStatement();
				boolean result2 = st.execute(sql1);
				Connection conn3 = DBConnecter.getConnection();
				String sql2 = "UPDATE `supermarket`.`product` SET `quantity` = '"+(totalquant-quantity2)+"'"
						+ " WHERE (`Product_id` = '"+idtxt.getText()+"')";
				 st = conn3.createStatement();
				 boolean result3 = st.execute(sql2);
				 JOptionPane.showMessageDialog(null, "you are buy "+quantity.getText()+
						 " product with cost +"+totalprice);

				
			}else {
				JOptionPane.showMessageDialog(null, "No Enough products");
			} 
			
		}else {
			JOptionPane.showMessageDialog(null, "there is an error");
		}
    	
    	
    }
    
    

    
    
    
    
    
    
    public void orderTable() {

		col_orderid.setCellValueFactory(new PropertyValueFactory<>("ID"));
		col_customerid.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		col_totalprice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		col_productid.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
		oblist2 = DBConnecter.getDataSaleOrder(LoginController.ID);
		orderTable.setItems(oblist2);

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
   
   
   
   
    
    public  void change(ActionEvent event) throws Exception {
    	Connection conn = DBConnecter.getConnection();
		String sql = "select * from supermarket.customer where customer_id= '" +LoginController.ID + "'";
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		if (result.next()) {
			String pass = result.getString(6);
			if ( prevpassword.getText().equals(pass)) {
				String sql2 = "UPDATE `supermarket`.`customer` SET `password` = '"
			+newpassword.getText()+"'"+ " WHERE (`customer_id` = '"+LoginController.ID +"')";
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
    

    public  void refresh1(ActionEvent event) throws Exception {
    	ProdTable();
    }
    
    public  void refresh2(ActionEvent event) throws Exception {
    	orderTable();
  }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProdTable();
		orderTable();
		
	}

}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBConnecter {
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/supermarket?autoReconnect=true&useSSL=false", "root", "Salah123321");
		return connection;
	}
	
	
	
	public static ObservableList<BuyOrder> getDataBuyOrder() {
		Connection conn;
		ObservableList<BuyOrder> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.buyorder");
			while (st.next()) {
				oblist.add(new BuyOrder(st.getString("Order_id"), st.getString("supplier_id"),
						st.getString("product_id"),st.getString("Date"),st.getString("TotalPrice")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	
	

	public static ObservableList<Childrens> getDatachild() {
		Connection conn;
		ObservableList<Childrens> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.childrins");
			while (st.next()) {
				oblist.add(new Childrens(st.getString("child_id"),st.getString("emp_id"),
						st.getString("child_name"),st.getString("DateOfBirth"),st.getString("gender")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	

	public static ObservableList<Customer> getDataCustomer() {
		Connection conn;
		ObservableList<Customer> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.customer");
			while (st.next()) {
				oblist.add(new Customer(st.getString("customer_id"), st.getString("customer_name"),
						st.getString("phone"),	st.getString("gender"),
						st.getString("city"), st.getString("password")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	public static ObservableList<Department> getDataDepartment() {
		Connection conn;
		ObservableList<Department> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.department");
			while (st.next()) {
				oblist.add(new Department(st.getString("Dep_id"),st.getString("Departmentname"),
						st.getString("city"),st.getString("manager")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	//eid,password,firstName,lastName,DOB,address,phoneNumber,salary
	public static ObservableList<Employee> getDataEmployee() {
		Connection conn;
		ObservableList<Employee> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.employee");
			while (st.next()) {
				oblist.add(new Employee(st.getString("Emp_id"),st.getString("Dep_id"), st.getString("Emp_name"),
						st.getString("Gender"),st.getString("dateOfBirth"),st.getString("hiredate"),
						st.getString("firedate"), st.getString("phone"), st.getString("city"),
						st.getString("password"),st.getString("Salary")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	public static ObservableList<Product> getDataproduct() {
		Connection conn;
		ObservableList<Product> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("select * from supermarket.product");
			while (st.next()) {
				oblist.add(new Product(st.getString("Product_id"), st.getString("Product_name"),
						st.getString("quantity"),st.getString("brand"),st.getString("costPricePerOne"),
						st.getString("SALEPricePerOne"),st.getString("category"),st.getString("department_id") ));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	

	public static ObservableList<SellOrder> getDataSaleOrder() {
		Connection conn;
		ObservableList<SellOrder> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.sellorder");
			while (st.next()) {
				oblist.add(new SellOrder(st.getString("Order_id"), st.getString("customer_id"),
						st.getString("product_id"),st.getString("Date"),st.getString("TotalPrice")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	public static ObservableList<SellOrder> getDataSaleOrder(String id) {
		Connection conn;
		ObservableList<SellOrder> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.sellorder where customer_id = '"+id+"'");
			while (st.next()) {
				oblist.add(new SellOrder(st.getString("Order_id"), st.getString("customer_id"),
						st.getString("product_id"),st.getString("Date"),st.getString("TotalPrice")));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	
	
	
	
	public static ObservableList<Supplier> getDataSupplier() {
		Connection conn;
		ObservableList<Supplier> oblist = FXCollections.observableArrayList();
		try {
			conn = DBConnecter.getConnection();
			ResultSet st = conn.createStatement().executeQuery("SELECT * FROM supermarket.supplier");
			while (st.next()) {
				oblist.add(new Supplier(st.getString("sup_id"), st.getString("sup_name")
						,st.getString("city") ));

			}
			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
	}
	
	
	
}

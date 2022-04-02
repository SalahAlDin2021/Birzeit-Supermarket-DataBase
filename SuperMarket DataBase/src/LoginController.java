import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML
	TextField userid;
	@FXML
	TextField password;
	@FXML
	ToggleGroup select1;
	@FXML
	RadioButton customerSelect;
	@FXML
	RadioButton employeeSelect;
	@FXML
	RadioButton managerSelect;
	
	static String ID ;
	
	public  void LogIn(ActionEvent event) throws Exception {
		if(customerSelect.isSelected()) {
			Connection conn = DBConnecter.getConnection();
			String sql = "select * from supermarket.customer where customer_id= '" + userid.getText() + "'";
			System.out.print("select * from supermarket.employee where Emp_id= '" + userid.getText() + "'");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			if (result.next()) {
				String userID = result.getString("customer_id");
				String pass = result.getString("password");
				if (userid.getText().equals(userID) && password.getText().equals(pass)) {
					System.out.println(userid.getText() + " " + password.getText() );
					ID = userid.getText() ;
					Parent pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Customer.fxml"));
					Scene scene = new Scene(pane);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
					  System.out.println("hi"); 
					  System.out.println("sucsess");
				}else {
					JOptionPane.showMessageDialog(null, "the username or passward is incorrect");
				}
			}else {
				JOptionPane.showMessageDialog(null, "there is an error");
			}
			
		}else if(employeeSelect.isSelected()) {
			Connection conn = DBConnecter.getConnection();
			String sql = "select * from supermarket.employee where Emp_id= '" + userid.getText() + "'";
			System.out.println("select * from supermarket.employee where Emp_id= '" + userid.getText() + "'");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			if (result.next()) {
				String userID = result.getString("Emp_id");
				String pass = result.getString("password");
				if (userid.getText().equals(userID) && password.getText().equals(pass)) {
					System.out.println(userid.getText() + " " + password.getText() );
					ID = userid.getText() ;
					Parent pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Employee.fxml"));
					Scene scene = new Scene(pane);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
					  System.out.println("hi"); 
					  System.out.println("sucsess");
				}else {
					JOptionPane.showMessageDialog(null, "the username or passward is incorrect");
				}
			}else {
				JOptionPane.showMessageDialog(null, "there is an error");
			}
			
			
		}else {
			Connection conn = DBConnecter.getConnection();
			String sql = "select * from supermarket.employee e , supermarket.department d where e.Emp_id='" 
			+ userid.getText() + "' and d.manager = '"+userid.getText() +"'" ;

			System.out.println("select * from supermarket.employee e , supermarket.department d where e.Emp_id='" 
					+ userid.getText() + "' and d.manager = '"+userid.getText() +"'");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			if (result.next()) {
				String userID = result.getString("Emp_id");
				String pass = result.getString("password");
				if (userid.getText().equals(userID) && password.getText().equals(pass)) {
					System.out.println(userid.getText() + " " + password.getText() );
					ID = userid.getText() ;
					Parent pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Manager.fxml"));
					Scene scene = new Scene(pane);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
					  System.out.println("hi"); 
					  System.out.println("sucsess");
				}else {
					JOptionPane.showMessageDialog(null, "the username or passward is incorrect");
				}
			}else {
				JOptionPane.showMessageDialog(null, "there is an error");
			}
			
		}
		
		
	}
	
	
	public  void signup(ActionEvent event) throws Exception {
		if(customerSelect.isSelected()) {
			Parent pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene scene = new Scene(pane);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			
		}else {
			JOptionPane.showMessageDialog(null, "the SignUp just to Customers\n , SignUp employees done by manager");
		}
		
		
	}
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}

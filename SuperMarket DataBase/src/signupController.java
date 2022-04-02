import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class signupController implements Initializable{
	
	@FXML
	private TextField id ;
	@FXML
	private TextField name ;
	@FXML
	private TextField gender ;
	@FXML
	private TextField phone ;
	@FXML
	private TextField city ;
	@FXML
	private TextField pass ;
	
	public  void signup(ActionEvent event) throws Exception {
		
		Connection conn = DBConnecter.getConnection();
    	String sql ="INSERT INTO `supermarket`.`customer` (`customer_id`, `customer_name`, `phone`, `gender`,"
    			+ " `city`, `password`) VALUES ('"+id.getText()+"', '"+name.getText()+"', '"+phone.getText()+"',"
    					+ " '"+gender.getText()+"', '"+city.getText()+"', '"+pass.getText()+"')";
    			
    	Statement st = conn.createStatement();
		boolean result3 = st.execute(sql);
		JOptionPane.showMessageDialog(null, "Welcome to Our Super market :) ");
		
		
		
	}
	
	public  void back(ActionEvent event) throws Exception {
		Parent pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(pane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Drive extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,900,560);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Birzeit SuperMarket 'COMP333'");
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	}

}

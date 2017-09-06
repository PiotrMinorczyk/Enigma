package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/application/fxml/View.fxml"));
		Pane pane = loader.load();
		// ViewController controler = loader.getController();

		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Symulator Enigmy");
		primaryStage.show();
	}
}
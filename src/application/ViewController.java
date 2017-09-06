package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ViewController {

	@FXML
	private Button buttonn1;

	@FXML
	private Button buttonn2;

	@FXML
	private TextArea textIn;

	@FXML
	private TextArea textResoult;

	public ViewController() {

	}

	@FXML
	void initialize() {
		textIn.textProperty().addListener((ov, oldValue, newValue) -> {
			textIn.setText(newValue.toUpperCase());
		});
		textIn.setWrapText(true);
		textResoult.setWrapText(true);
		textResoult.setEditable(false);

	}

	@FXML
	public void codeButton() {
		textResoult.setText(Enigma.codeText(textIn.getText()));
	}

	@FXML
	public void exitButton() {
		Platform.exit();
	}
}

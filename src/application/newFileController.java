package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newFileController implements Initializable {


	@FXML
	private TextField fileName;

	@FXML
	private Button fnish;

	@FXML
	private Button conceal;

	@FXML
	private ComboBox<String> type;

	private Stage stage;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		type.getItems().addAll(".bf",".Ook");
	}


	public void finish(){
		if(fileName.getText()==null||fileName.getText().equals("")){
			Alert error=new Alert(Alert.AlertType.WARNING,"文件名不能为空！");
			Button confirm=new Button();
			error.show();
			confirm.setOnAction((ActionEvent e)->{
				 error.close();
			});
		}
		else{
			MenuController.user.setPrompt(fileName.getText()+type.getValue());
			stage.close();
		}
	}

	public void setStage(Stage stage){
		this.stage=stage;
	}

}

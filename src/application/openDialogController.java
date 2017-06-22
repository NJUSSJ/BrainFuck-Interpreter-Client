package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import runner.ClientRunner;

public class openDialogController implements Initializable {
	@FXML
	private Stage stage;

	@FXML
	private ComboBox<String> box;

	@FXML
	private Button open;

	public String list;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		for(int i=0;i<MenuController.user.getList().length;i++){
			box.getItems().add(MenuController.user.getList()[i]);
		}

	}



	public void open(){
		String file=box.getValue();
		try {
			String code=ClientRunner.remoteHelper.getIOService().readFile(MenuController.user.getUsername(), file);
			MenuController.user.setPrompt(file);
			MenuController.user.setCode(code);
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		stage.close();
	}

	public void setStage(Stage stage){
		this.stage=stage;
	}
}

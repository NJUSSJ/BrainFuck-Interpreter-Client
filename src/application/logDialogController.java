package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import runner.ClientRunner;

public class logDialogController implements Initializable {

	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	
	private Button log_in;
	
	@FXML
	private Button newAccount;
	
	private Stage stage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自动生成的方法存根

	}
	
	
	//Log
	public void Log(){
		User user=new User("");
		if(username.getText().equals("")||username.getText()==null){
			Alert error=new Alert(Alert.AlertType.WARNING,"Username can Not be Empty!");
			Button confirm=new Button();
			error.show();
			confirm.setOnAction((ActionEvent e)->{
				 error.close();
			});
		}
		try {
			String username_temp=username.getText();
			String password_temp=password.getText();
			
			boolean sign=ClientRunner.remoteHelper.getUserService().Log_in(username_temp, password_temp);
			if(sign){
				stage.close();
				user.setUsername(username_temp);
				user.setPassword(password_temp);
				MenuController.user=user;
				//set list
				String list=ClientRunner.remoteHelper.getIOService().readFileList(MenuController.user.getUsername());
				MenuController.user.setList(list.split(" "));
			
			}
			else{
				Alert error=new Alert(Alert.AlertType.ERROR,"Username or Password Is Wrong!");
				Button confirm=new Button();
				error.show();
				confirm.setOnAction((ActionEvent e)->{
					 error.close();
				});
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	//new account
	public void newAccount (){
		User user=new User("");
		user.setUsername(username.getText());
		user.setPassword(password.getText());
		try {
			boolean sign=ClientRunner.remoteHelper.getUserService().new_Account(user.getUsername(), user.getPassword());
		
			if(sign){
				Alert error=new Alert(Alert.AlertType.INFORMATION,"User Created");
				Button confirm=new Button();
				error.show();
				confirm.setOnAction((ActionEvent e)->{
					 error.close();
				});
				MenuController.user=user;
			}
			else{
				if(username.getText()==null||username.getText().equals("")){
					Alert error=new Alert(Alert.AlertType.INFORMATION,"用户名不能为空.");
					Button confirm=new Button();
					error.show();
					confirm.setOnAction((ActionEvent e)->{
						 error.close();
					});
				}
				else{Alert error=new Alert(Alert.AlertType.INFORMATION,"User has existed.");
				Button confirm=new Button();
				error.show();
				confirm.setOnAction((ActionEvent e)->{
					 error.close();
				});
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		stage.close();
	}
	
	
	public void setStage(Stage stage){
		this.stage=stage;
	}

}

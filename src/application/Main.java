package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import runner.ClientRunner;


public class Main extends Application {
	private static Stage primaryStage;


	@Override

	public void start(Stage primaryStage) {
		try {
			Main.primaryStage=primaryStage;

			Parent root=FXMLLoader.load(getClass().getResource("/application/UI.fxml"));

			primaryStage.setTitle("IDE");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new ClientRunner();
		launch(args);

	}

	//logDialog
	public static void showLogDislog(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/logDialog.fxml"));

			AnchorPane page=(AnchorPane)loader.load();
			Scene scene=new Scene(page);
			Stage logStage=new Stage();

			logStage.setTitle("Log in");
			logStage.initModality(Modality.WINDOW_MODAL);
			logStage.initOwner(primaryStage);
			logStage.setScene(scene);

			//Set User to Controller
			logDialogController controller=loader.getController();
			controller.setStage(logStage);


			logStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//newFileDialog
	public static void showNewFileDialog(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/newFile.fxml"));

			AnchorPane page=(AnchorPane)loader.load();
			Scene scene=new Scene(page);
			Stage newStage=new Stage();

			newStage.setTitle("New File");
			newStage.initModality(Modality.WINDOW_MODAL);
			newStage.initOwner(primaryStage);
			newStage.setScene(scene);

			//set controller stage
			newFileController controller=loader.getController();
			controller.setStage(newStage);

			newStage.showAndWait();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	//OpenDialog
	public static void showOpenDialog(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/openDialog.fxml"));

			AnchorPane page=(AnchorPane)loader.load();
			Scene scene=new Scene(page);
			Stage newStage=new Stage();

			newStage.setTitle("Open");
			newStage.initModality(Modality.WINDOW_MODAL);
			newStage.initOwner(primaryStage);
			newStage.setScene(scene);

			//set controller stage
			openDialogController controller=loader.getController();
			controller.setStage(newStage);

			newStage.showAndWait();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	//VersionDialog
		public static void showVersionDialog(){
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("/application/versionDialog.fxml"));

				AnchorPane page=(AnchorPane)loader.load();
				Scene scene=new Scene(page);
				Stage newStage=new Stage();

				newStage.setTitle("Version");
				newStage.initModality(Modality.WINDOW_MODAL);
				newStage.initOwner(primaryStage);
				newStage.setScene(scene);

				//set controller stage
				versionDialogController controller=loader.getController();
				controller.setStage(newStage);

				newStage.showAndWait();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
}

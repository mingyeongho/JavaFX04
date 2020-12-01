package dialog;

import java.util.Optional;
import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		Menu dlgMenu = new Menu("Dialog");
		MenuItem dlg1 = new MenuItem("Information");
		MenuItem dlg2 = new MenuItem("Warning");
		MenuItem dlg3 = new MenuItem("Error");
		MenuItem dlg4 = new MenuItem("Confirmation");
		MenuItem dlg5 = new MenuItem("TextInput");
		MenuItem dlg6 = new MenuItem("Choice");
		dlgMenu.getItems().addAll(dlg1,dlg2,dlg3,dlg4,dlg5,dlg6);
		
		menuBar.getMenus().addAll(dlgMenu);
		root.setTop(menuBar);
		
		dlg1.setOnAction(event->{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Content Text");
			alert.showAndWait();
		});
		dlg2.setOnAction(event->{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Header Text");
			alert.setContentText("Content Text");
			alert.showAndWait();
		});
		dlg3.setOnAction(event->{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Content Text");
			alert.showAndWait();
		});
		dlg4.setOnAction(event->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText(null);
			alert.setContentText("Content Text");
			alert.showAndWait();
		});
		dlg5.setOnAction(event->{
			TextInputDialog dialog = new TextInputDialog("Kim");
			dialog.setTitle("Title");
			dialog.setHeaderText("Shown a Header Text");
			dialog.setContentText("Please enter your name");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				System.out.println("Your name: " + result.get());
			}
		});
		dlg6.setOnAction(event->{
			Vector<String> choices = new Vector<>();
			choices.add("Plant");
			choices.add("Animal");
			choices.add("Person");
			ChoiceDialog<String> dialog = new ChoiceDialog<String>("Animal", choices);
			dialog.setTitle("Title");
			dialog.setHeaderText("Shown a Header Text");
			dialog.setContentText("Choose one: ");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				System.out.println("Your choice: " + result.get());
			}
		});
		
		
		
		
		
		
		
		
		
		Scene scene = new Scene(root,400,400);
		
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

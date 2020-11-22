package fileChooser;


import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("jpeg Image", "*.jpg"),
				new FileChooser.ExtensionFilter("png Image", "*.png"),
				new FileChooser.ExtensionFilter("gif Image", "*.gif")
		);
		
		// MenuBar
		MenuBar menuBar = new MenuBar();
		
		// Menu
		Menu fileMenu = new Menu("File");
		
		// MenuItem
		MenuItem openItem = new MenuItem("_Open");
		
		MenuItem exitItem = new MenuItem("E_xit");
		
		// Event
		openItem.setOnAction(event-> {
			File file = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				try {
					Image img = new Image(new FileInputStream(file));
					ImageView imgView = new ImageView(img);
					imgView.fitWidthProperty().bind(primaryStage.widthProperty());
					imgView.setPreserveRatio(true);
					root.setCenter(new ScrollPane(imgView));
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		exitItem.setOnAction(event->System.exit(0));
		
		// Menu + MenuItem
		fileMenu.getItems().addAll(openItem, exitItem);
		
		// MenuBar + Menu
		menuBar.getMenus().addAll(fileMenu);
		
		// root + MenuBar
		root.setTop(menuBar);
		
		
		
		Scene scene = new Scene(root, 500, 500);
		
		primaryStage.setTitle("UI Control Example");
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

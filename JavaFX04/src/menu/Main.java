package menu;


import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		
		// Menu
		Menu fileMenu = new Menu("_File");
		Menu editMenu = new Menu("_Edit");
		Menu projectMenu = new Menu("Pro_ject");
		Menu helpMenu = new Menu("_Help");
		
		// MenuItem
		// FileMenu menuItem
		MenuItem newItem = new MenuItem("_New");
		newItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+N"));
		Image newImg = new Image(new FileInputStream("src/images/New_32x32.png"));
		newItem.setGraphic(new ImageView(newImg));
		
		MenuItem openItem = new MenuItem("_Open File");
		Image openImg = new Image(new FileInputStream("src/images/Open_32x32.png"));
		openItem.setGraphic(new ImageView(openImg));
		
		MenuItem exitItem = new MenuItem("E_xit");
		
		// EditMenu menuItem
		MenuItem copyItem = new MenuItem("_Copy");
		MenuItem pasteItem = new MenuItem("_Paste");
		
		// ProjectMenu menuItem
		CheckMenuItem buildItem = new CheckMenuItem("Build Automatically");
		buildItem.setSelected(true);
		
		// Event
		newItem.setOnAction(event->{
			System.out.println("New menu item was selected");
		});
		exitItem.setOnAction(event-> System.exit(0));
		
		// File Menu + Item
		fileMenu.getItems().addAll(newItem, openItem, new SeparatorMenuItem(), exitItem);
		
		//EditMenu + Item
		editMenu.getItems().addAll(copyItem, pasteItem);
		
		// ProjectMenu + Item
		projectMenu.getItems().addAll(buildItem);
		
		// MenuBar + Menu
		menuBar.getMenus().addAll(fileMenu, editMenu, projectMenu, helpMenu);
		
		// root + MenuBar
		root.setTop(menuBar);
		
		Scene scene = new Scene(root, 400, 350);
		
		primaryStage.setTitle("UI Control Example");
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
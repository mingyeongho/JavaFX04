package test;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(15.0);
		
		Button btn1 = new Button();
		btn1.setText("Hello");
		btn1.setOnAction(event-> {
			if (btn1.getText().equals("Hello") ) {
				btn1.setText("Accept");
			} else {
				btn1.setText("Hello");
			}
		});
		
		Button btn2 = new Button("Accept");
		DropShadow shad = new DropShadow();
		btn2.setOnAction(event-> {
			if (btn2.getText().equals("Hello") ) {
				btn2.setText("Accept");
			} else {
				btn2.setText("Hello");
			}
		});
		btn2.setOnMouseEntered(event-> {
			btn2.setEffect(shad);
		});
		btn2.setOnMouseExited(event-> {
			btn2.setEffect(null);
		});
		
		Image img = new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/Check_16x16.png");
		Image declineImg = new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/Delete_16x16.png");
		Button btn3 = new Button("Accept", new ImageView(img));
		btn3.setOnAction(event-> {
			if (btn3.getText().equals("Accept") ) {
				btn3.setText("Decline");
				btn3.setGraphic(new ImageView(declineImg));
			} else {
				btn3.setText("Accept");
				btn3.setGraphic(new ImageView(img));
			}
		});
		
		root.getChildren().addAll(btn1, btn2, btn3);
		
		Scene scene = new Scene(root, 300, 300);
		
		primaryStage.setTitle("test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

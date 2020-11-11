package calculator2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.setHgap(7.0);
		root.setVgap(7.0);
		root.setPadding(new Insets(10));
		
		Label result = new Label();
		result.setTextFill(Color.ORANGE);
		result.setAlignment(Pos.CENTER_RIGHT);
		result.setPrefWidth(599.0);
		
		Button[] btns = new Button[10];
		for (int i = 0; i < 10; i++) {
			btns[i] = new Button(Integer.toString(i));
		}
		
		
		root.add(result, 0, 0, 3, 1);
		root.add(btns[0], 0, 4, 1, 1);
		root.add(btns[1], 0, 3, 1, 1);
		root.add(btns[2], 1, 3, 1, 1);
		root.add(btns[3], 2, 3, 1, 1);
		root.add(btns[4], 0, 2, 1, 1);
		root.add(btns[5], 1, 2, 1, 1);
		root.add(btns[6], 2, 2, 1, 1);
		root.add(btns[7], 0, 1, 1, 1);
		root.add(btns[8], 1, 1, 1, 1);
		root.add(btns[9], 2, 1, 1, 1);
		
		Scene scene = new Scene(root, 400, 600);
		
		primaryStage.setTitle("JavaFX 계산기(프로그램적)");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

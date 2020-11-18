package colorPicker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setStyle("-fx-background-color: black");
		
		Circle circle = new Circle(50);
		circle.setFill(Color.RED);
		
		ColorPicker colorPicker1 = new ColorPicker();
		colorPicker1.setValue(Color.BLACK);
		colorPicker1.setOnAction(event-> {
			root.setStyle("-fx-background-color: #" + colorPicker1.getValue().toString().substring(2));
		});
		
		ColorPicker colorPicker2 = new ColorPicker();
		colorPicker2.setValue(Color.RED);
		colorPicker2.setOnAction(event-> {
			circle.setFill(colorPicker2.getValue());
		});
		
		root.getChildren().addAll(circle, colorPicker1, colorPicker2);
		
		Scene scene = new Scene(root, 300, 300);
		
		primaryStage.setTitle("test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

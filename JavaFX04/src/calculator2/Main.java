package calculator2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	int i = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPrefSize(400, 600);
		root.setHgap(7.0);
		root.setVgap(7.0);
		root.setPadding(new Insets(10));
		
		
		Label result = new Label();
		result.setStyle("-fx-background-color: orange");
		result.setAlignment(Pos.CENTER_RIGHT);
		result.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		result.setPrefSize(599, 90);
		
		Button[] btns = new Button[10];
		for (i = 0; i < 10; i++) {
			btns[i] = new Button(Integer.toString(i));
			btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			btns[i].setPrefSize(90, 90);
			btns[i].setOnAction(event-> {
				if (result.getText().equals("0")) {
					result.setText(btns[i].getText());
				} else {
					result.setText(result.getText()+btns[i].getText());
				}
			});
		}
		Button clear = new Button("C");
		clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		clear.setPrefSize(180, 90);
		Button dot = new Button(".");
		dot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		Button div = new Button("/");
		div.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		Button plu = new Button("+");
		plu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		Button min = new Button("-");
		min.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		Button mul = new Button("*");
		mul.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		Button equ = new Button("=");
		equ.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				result.setText(result.getText()+);
				
			}
		};
		
		root.add(result, 0, 0, 4, 1);
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
		root.add(equ, 2, 4, 1, 2);
		root.add(dot, 1, 4 , 1, 1);
		root.add(clear, 0, 5, 2, 1);
		root.add(plu, 3, 4, 1, 2);
		root.add(min, 3, 3, 1, 1);
		root.add(mul, 3, 2, 1, 1);
		root.add(div, 3, 1, 1, 1);
		
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setTitle("JavaFX 계산기(프로그램적)");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

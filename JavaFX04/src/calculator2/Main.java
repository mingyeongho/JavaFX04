package calculator2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	String[] operators = {"+", "-", "*", "/"};
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPrefSize(400, 600);
		root.setHgap(7.0);
		root.setVgap(7.0);
		root.setPadding(new Insets(10));
		
		VBox vbox = new VBox();
		
		Label formula = new Label();
		Label result = new Label();
		
		formula.setStyle("-fx-background-color: orange");
		formula.setAlignment(Pos.CENTER_RIGHT);
		formula.setFont(new Font(20));
		formula.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		formula.setPrefSize(380, 37);
		
		result.setStyle("-fx-background-color: orange");
		result.setFont(new Font(25));
		result.setAlignment(Pos.CENTER_RIGHT);
		result.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		result.setPrefSize(380, 40);
		
		vbox.getChildren().addAll(formula, result);
		
		
		Button[] btns = new Button[10];
		for (int i = 0; i < 10; i++) {
			btns[i] = new Button(Integer.toString(i));
			btns[i].setPrefSize(90, 90);
			btns[i].setStyle("-fx-background-color: #CCCCFF");
			btns[i].setFont(new Font(30));
			Button num = btns[i];
			num.setOnAction(event-> {
				if (result.getText().equals("0")) {
					result.setText(num.getText());
				} else {
					result.setText(result.getText()+num.getText());
				}
			});
		}
		
		Button[] operator = new Button[4];
		for (int i = 0; i < 4; i++) {
			operator[i] = new Button(operators[i]);
			operator[i].setFont(new Font(30));
			operator[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			operator[i].setStyle("-fx-background-color: #6666FF");
			Button oper = operator[i];
			oper.setOnAction(event->{
				formula.setText(formula.getText()+result.getText()+oper.getText());
				result.setText("");
			});
		}
		
		
		Button clear = new Button("C");
		clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		clear.setStyle("-fx-background-color: #CCCCFF");
		clear.setFont(new Font(30));
		clear.setPrefSize(180, 90);
		clear.setOnAction(event->{
			formula.setText("");
			result.setText("");
		});
		
		Button dot = new Button(".");
		dot.setFont(new Font(30));
		dot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		dot.setStyle("-fx-background-color: #CCCCFF");
		dot.setOnAction(event-> {
			result.setText(result.getText()+".");
		});
		
		Button equ = new Button("=");
		equ.setFont(new Font(30));
		equ.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		equ.setStyle("-fx-background-color: #CCCCFF");
		equ.setOnAction(event -> {
			formula.setText(formula.getText()+result.getText());
			result.setText("");
			
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("js");
		    try {
		    	double res = Double.parseDouble(String.valueOf(engine.eval(formula.getText())));
		    	result.setText(Double.toString(res));
		    } catch(Exception e) {
		    	e.printStackTrace();
		    }
		});
		
		
		root.add(vbox, 0, 0, 4, 1);
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
		root.add(operator[0], 3, 4, 1, 2);
		root.add(operator[1], 3, 3, 1, 1);
		root.add(operator[2], 3, 2, 1, 1);
		root.add(operator[3], 3, 1, 1, 1);
		
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

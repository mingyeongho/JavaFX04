package Exercise02;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		TextArea ta = new TextArea();
		ta.setWrapText(true);
		ta.setEditable(false);
		ta.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		GridPane panel = new GridPane(); 
		panel.setHgap(15);
		TextField tf = new TextField();
		tf.setPrefColumnCount(40);
		tf.setPromptText("입력하세요...");
		Button btn = new Button("Submit");
		panel.add(tf, 0, 0, 2, 1);
		panel.add(btn,  2,  0, 1, 1);
		
		root.setCenter(ta);
		BorderPane.setMargin(panel, new Insets(10,0,0,0));
		root.setBottom(panel);
		
		btn.setOnAction(event-> {
			ta.appendText(tf.getText() + "\n");
			ta.selectPositionCaret(ta.getLength());
			tf.clear();
		});
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("Exercise02");
		primaryStage.setScene(scene);
		primaryStage.show();
		tf.requestFocus();
	}
	public static void main(String[] args) {
		launch(args);

	}

}

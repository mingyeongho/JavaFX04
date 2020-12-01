package thread1;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

	Label label = new Label("00:00:00");
	Boolean stop = true;
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		
		label.setStyle("-fx-background-color: Black");
		label.setTextFill(Color.WHITE);
		label.setPrefWidth(200);
		label.setAlignment(Pos.CENTER);
		label.setFont(new Font("Times New Roman", 40));
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		label.setText(fmt.format(new Date()));
		
		Button startbtn = new Button("Start");
		Button stopbtn = new Button("Stop");
		
		startbtn.setOnAction(event-> {
			if (!stop) {
				return;
			}
			stop = false;
			Thread th = new Thread(() -> {
				while(!stop) {
					Platform.runLater(()-> {
						label.setText(fmt.format(new Date()));
					});
					try {
						Thread.sleep(1000);
					} catch(InterruptedException e) {
						return;
					}
				}
			});
			th.setDaemon(true);
			th.start();
		});
		
		stopbtn.setOnAction(event-> {
			stop = true;
		});
		
		root.getChildren().addAll(label, startbtn, stopbtn);
		
		Scene scene = new Scene(root, 250, 150);
		primaryStage.setTitle("Time");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

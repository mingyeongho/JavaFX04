package mediaControl;

import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: Black");
		
		File file = new File("C:\\Users\\min gyeong ho\\git\\JavaFX04\\JavaFX04\\src\\icon_media_sounds\\media\\test.mp4");
		Media media = new Media(file.toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		player.setAutoPlay(false);
		MediaView mediaView = new MediaView(player);
		mediaView.setPreserveRatio(true);
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(30);
		hbox.setStyle("fx-background-color: Black");
		
		Button pauseBtn = new Button();
		pauseBtn.setGraphic(new ImageView(new Image(new FileInputStream("C:\\Users\\min gyeong ho\\git\\JavaFX04\\JavaFX04\\src\\icon_media_sounds\\icons\\Pause.png"))));
		pauseBtn.setOnAction(event->{
			player.pause();
		});
		
		Button playBtn = new Button();
		playBtn.setGraphic(new ImageView(new Image(new FileInputStream("C:\\Users\\min gyeong ho\\git\\JavaFX04\\JavaFX04\\src\\icon_media_sounds\\icons\\Play.png"))));
		playBtn.setOnAction(event->{
			player.play();
		});
		
		Button stopBtn = new Button();
		stopBtn.setGraphic(new ImageView(new Image(new FileInputStream("C:\\Users\\min gyeong ho\\git\\JavaFX04\\JavaFX04\\src\\icon_media_sounds\\icons\\Stop.png"))));
		stopBtn.setOnAction(event->{
			player.stop();
		});
		
		hbox.getChildren().addAll(pauseBtn, playBtn, stopBtn);
		root.setCenter(mediaView);
		root.setBottom(hbox);
		
		Scene scene = new Scene(root, 400, 350);
		primaryStage.setTitle("UI Control Example");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

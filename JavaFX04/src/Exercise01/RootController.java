package Exercise01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class RootController implements Initializable{
	@FXML GridPane pane;
	
	int rand, i, j;
	Image imgs[] = {new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/black.png"),
			new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/green.png"),
			new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/pig.jpg"),
			new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/white.png"),
			new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/yellow.png"),
			new Image("file:///C:/Users/min gyeong ho/git/JavaFX04/JavaFX04/src/images/red.png"),};
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Thread init = new Thread(() -> {
			for (i = 0; i < pane.getRowConstraints().size(); i++) {
				for (j = 0; j < pane.getColumnConstraints().size(); j++) {
					rand = (int)(Math.random()*6);
					ImageView img = new ImageView(imgs[rand]);
					img.setFitWidth(55);
					img.setFitHeight(55);
					Platform.runLater(()-> {
						GridPane.setConstraints(img, j, i);
						pane.getChildren().add(img);
						
					});
				}
			}
		});
		init.setDaemon(true);
		init.start();
	}
}

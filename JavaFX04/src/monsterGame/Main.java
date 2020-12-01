package monsterGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class GamePane extends AnchorPane {
	static final long monsterDelay = 100;
	final int AVATAR_MOVE = 10;
	
	Stage stage;
	Label avatar, monster;
	
	public GamePane(Stage stage) {
		this.stage = stage;
		
		avatar = new Label("@");
		monster = new Label("M");
		
		avatar.setPrefSize(15, 15);
		avatar.setLayoutX(100);
		avatar.setLayoutY(100);
		avatar.setTextFill(Color.RED);
		
		monster.setPrefSize(15, 15);
		monster.setLayoutX(250);
		monster.setLayoutY(250);
		
		this.getChildren().addAll(avatar, monster);
		
		this.setOnKeyPressed(event-> {
			if (event.getCharacter() == "q") {
				System.exit(0);
			}
			switch (event.getCode()) {
				case UP:
					avatar.setLayoutY(avatar.getLayoutY() - AVATAR_MOVE);
					break;
				case DOWN:
					avatar.setLayoutY(avatar.getLayoutY() + AVATAR_MOVE);
					break;
				case LEFT:
					avatar.setLayoutX(avatar.getLayoutX() - AVATAR_MOVE);
					break;
				case RIGHT:
					avatar.setLayoutX(avatar.getLayoutX() + AVATAR_MOVE);
					break;
			}
		});
		
		Thread th = new Thread(new MonsterThread(stage, monster, avatar, monsterDelay));
		th.setDaemon(true);
		th.start();
	}
	
	class MonsterThread implements Runnable {
		Stage stage;
		Label from, to;
		long monsterDelay;
		final int MONSTER_MOVE = 5;
		
		public MonsterThread(Stage stage, Label from, Label to, long monsterDelay) {
			this.stage =stage;
			this.from = from;
			this.to = to;
			this.monsterDelay = monsterDelay;
		}
		
		@Override
		public void run() {
			int x = (int)from.getLayoutX();
			int y = (int)from.getLayoutY();
			while(true) {
				if (to.getLayoutX() < from.getLayoutX()) {
					x = x - MONSTER_MOVE;
				} else {
					x = x + MONSTER_MOVE;
				}
				if (to.getLayoutY() < from.getLayoutY()) {
					y = y - MONSTER_MOVE;
				} else {
					y = y + MONSTER_MOVE;
				}
				from.setLayoutX(x);
				from.setLayoutY(y);
				
				double gapX = Math.abs(to.getLayoutX() - from.getLayoutX());
				double gapY = Math.abs(to.getLayoutY() - from.getLayoutY());
				if (gapX < 10 && gapY < 10) {
					Platform.runLater(() -> {
						stage.setTitle("Avatar Dead!!");
					});
				} else {
					Platform.runLater(()-> {
						stage.setTitle("Avatar Alive!!");
					});
				}
				try {
					Thread.sleep(monsterDelay);
				} catch(Exception e) {
					return;
				}
			}
		}
	}
}

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GamePane root = new GamePane(primaryStage);
		
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setTitle("Monster Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		root.requestFocus();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

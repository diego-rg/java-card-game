package escoba.main;

import escoba.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		// Creates a stage from fxml file using an HBox container
		VBox rootNode = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		// Sets an icon for the app from an img
		mainStage.getIcons().add(new Image(Game.class.getResourceAsStream("/img/cards/1o.png")));
		// Creates the scene
		Scene mainScene = new Scene(rootNode, 1024, 768);
		// Links css file
		mainScene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());
		// Prepares the scene
		mainStage.setScene(mainScene);
		mainStage.setTitle("Escoba");
		// Starts the scene
		mainStage.show();
	}

	public static void main(String[] args) {
		MainController.initGame();
		launch(args);
	}
}

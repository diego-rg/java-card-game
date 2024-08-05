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
	public void start(Stage mainWindow) throws Exception {

		// Creates stage from fxml file using HBox container
		VBox root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		// Icon from img
		mainWindow.getIcons().add(new Image(Game.class.getResourceAsStream("/img/cards/1o.png")));
		// Creates the scene
		Scene scene = new Scene(root, 1024, 768);
		// Links css file
		scene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());
		// Prepares the scene
		mainWindow.setScene(scene);
		mainWindow.setTitle("Escoba");
		mainWindow.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("TACO INICIO:" + game.getTable().getStock().toString());
		System.out.println("MESA INICIO:" + game.getTable().getHand().toString());
		try {
			game.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TACO REPARTIDO:" + game.getTable().getStock().size());
		System.out.println(game.getTable().getHand().toString());
		System.out.println(game.getPlayers().get(1).getHand().toString());
		System.out.println(game.getPlayers().get(2).getHand().toString());

		launch(args);
	}
}

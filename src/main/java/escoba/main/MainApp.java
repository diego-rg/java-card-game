package escoba.main;

import escoba.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage ventanaPrincipal) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene scene = new Scene(root, 300, 150);
		ventanaPrincipal.setScene(scene);
		ventanaPrincipal.setTitle("Ejemplo con FXML");
		ventanaPrincipal.show();
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

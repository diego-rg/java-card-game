package escoba.game;

import java.io.FileNotFoundException;

import escoba.main.MainController;
import escoba.player.HandView;
import escoba.table.TableHandView;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GameControllerPrueba {
	@FXML
	private HBox menu;
	@FXML
	private HBox hand1;
	@FXML
	private HBox hand2;
	@FXML
	private HBox trick1;
	@FXML
	private HBox trick2;
	@FXML
	private HBox handTable;
	@FXML
	private HBox stock;
	@FXML
	private Text title;

	@FXML
	public void initialize() throws FileNotFoundException {
		title.setText("Escoba: a Spanish card game");
		HandView player1 = new HandView(MainController.game.getPlayerById(1), true);
		player1.render(hand1);
		HandView player2 = new HandView(MainController.game.getPlayerById(2), false);
		player2.render(hand2);
		TableHandView table = new TableHandView(MainController.game.getTable(), true);
		table.render(handTable);
	}
}

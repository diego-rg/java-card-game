package escoba.game;

import java.io.FileNotFoundException;

import escoba.main.MainController;
import escoba.player.HandView;
import escoba.table.StockView;
import escoba.table.TableHandView;
import escoba.trick.TrickView;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class GameControllerPrueba {
	@FXML
	private HBox menu;
	@FXML
	private HBox hand1;
	@FXML
	private HBox hand2;
	@FXML
	private StackPane trick1;
	@FXML
	private StackPane trick2;
	@FXML
	private HBox handTable;
	@FXML
	private StackPane stock;
	@FXML
	private Text title;

	@FXML
	public void initialize() throws FileNotFoundException {
		title.setText("Escoba: a Spanish card game");
		HandView player1Hand = new HandView(MainController.game.getPlayerById(1), true);
		player1Hand.render(hand1);
		HandView player2Hand = new HandView(MainController.game.getPlayerById(2), false);
		player2Hand.render(hand2);
		TrickView player1Trick = new TrickView(MainController.game.getPlayerById(1), false);
		player1Trick.render(trick1);
		TrickView player2Trick = new TrickView(MainController.game.getPlayerById(2), false);
		player2Trick.render(trick2);
		TableHandView table = new TableHandView(MainController.game.getTable(), true);
		table.render(handTable);
		StockView stockTable = new StockView(MainController.game.getTable(), false);
		stockTable.render(stock);
	}
}

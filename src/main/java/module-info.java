module escoba.main {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

	opens escoba.main to javafx.fxml;
	opens escoba.game to javafx.fxml;
	opens escoba.card to javafx.card;
	opens escoba.deck to javafx.fxml;
	opens escoba.player to javafx.player;
	opens escoba.table to javafx.fxml;
	opens escoba.trick to javafx.trick;
	opens escoba.state to javafx.state;

	exports escoba.main;
	exports escoba.game;
	exports escoba.card;
	exports escoba.deck;
	exports escoba.player;
	exports escoba.table;
	exports escoba.trick;
	exports escoba.state;
}

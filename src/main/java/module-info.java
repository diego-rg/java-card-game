module escoba.main {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

	opens escoba.main to javafx.fxml;
	opens escoba.game to javafx.fxml;

	exports escoba.main;
	exports escoba.game;
}

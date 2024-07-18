package escoba.game;

import org.junit.jupiter.api.Test;

public class GameTest {
	Game game = new Game();

	@Test
	void currentTurn() {
		try {
			game.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package escoba.main;

import escoba.game.Game;

public class MainApp {

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println(game.getTable().getStock().toString());
		System.out.println(game.getTable().getHand().toString());
		try {
			game.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(game.getTable().getStock().toString());
		System.out.println(game.getTable().getHand().toString());
	}
}

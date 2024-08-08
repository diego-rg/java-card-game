package escoba.main;

import escoba.game.Game;

public class MainController {
	public static Game game;

	/**
	 * 
	 */
	public MainController() {
		super();
		MainController.game = new Game();
	}

	public static void initGame() {
		try {
			new MainController();
			game.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Cartas en Taco: " + game.getTable().getStock().size());
		System.out.println("Cartas Mesa " + game.getTable().getHand().toString());
		System.out.println("Cartas J1 " + game.getPlayers().get(1).getHand().toString());
		System.out.println("Cartas J2 " + game.getPlayers().get(2).getHand().toString());
	}
}

package escoba.main;

import escoba.game.Game;

public class MainApp {

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
	}
}

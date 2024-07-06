package escoba.main;

import escoba.deck.Deck;

public class MainApp {

	public static void main(String[] args) {
		Deck spanishDeck = new Deck();
		System.out.println(spanishDeck.getCards().size());
	}
}

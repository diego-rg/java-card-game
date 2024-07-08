package escoba.trick;

import java.util.LinkedList;

import escoba.card.Card;

/**
 * Class that represents the cards won by the player each turn he sums 15 points
 */
public class Trick {
	private LinkedList<Card> cards;
	private boolean isEscoba;

	/**
	 * @param cards
	 * @param isEscoba
	 */
	public Trick(LinkedList<Card> cards, boolean isEscoba) {
		super();
		this.cards = cards;
		this.isEscoba = isEscoba;
	}

	/**
	 * @return the cards
	 */
	public LinkedList<Card> getCards() {
		return cards;
	}

	/**
	 * @return the isEscoba
	 */
	public boolean isEscoba() {
		return isEscoba;
	}

	@Override
	public String toString() {
		String data = "Trick [isEscoba=" + isEscoba + "] has the following cards:\n";
		for (Card c : cards) {
			data += c.toString() + "\n";
		}
		return data;
	}

}

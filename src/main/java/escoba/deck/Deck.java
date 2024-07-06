package escoba.deck;

import java.util.LinkedList;

import escoba.card.Figure;
import escoba.card.Suit;
import escoba.card.Card;

/**
 * Class that represents the spanish deck to play the game escoba
 */
public class Deck {
	private LinkedList<Card> cards;

	/**
	 *
	 */
	public Deck() {
		super();
		this.cards = createSpanishDeck();
	}

	/**
	 * @return the cards
	 */
	public LinkedList<Card> getCards() {
		return cards;
	}

	/**
	 * Generates all the cards for the spanish deck
	 * 
	 * @return HashSet<Card> the spanish full deck with 40 cards, 4 suits and 10 figures for each suit
	 * 
	 */
	private LinkedList<Card> createSpanishDeck() {
		LinkedList<Card> spanishDeck = new LinkedList<Card>();
		for (Suit f : Suit.values()) {
			for (Figure s : Figure.values()) {
				spanishDeck.add(new Card(s, f));
			}
		}
		return spanishDeck;
	}

	@Override
	public String toString() {
		String data = "Cards: \n";
		for (Card c : cards) {
			data += c.toString() + "\n";
		}
		return data;
	}
}

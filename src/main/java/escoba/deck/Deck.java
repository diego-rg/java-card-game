package escoba.deck;

import java.util.HashSet;

import escoba.card.Card;

/**
 * Class that represents the spanish deck to play the game escoba
 */
public class Deck {
	private HashSet<Card> cards;

	/**
	 * @param no params constructor
	 */
	public Deck() {
		super();
		this.cards = createSpanishDeck();
	}

	/**
	 * @return the cards
	 */
	public HashSet<Card> getCards() {
		return cards;
	}

	/**
	 * @return HashSet<Card> the spanish full deck with 40 cards, 4 suits and 10 figures for each suit
	 * 
	 */
	private HashSet<Card> createSpanishDeck() {
		HashSet<Card> spanishDeck = new HashSet<Card>();

		for (Suit s : Suit.values()) {
			for (Figure f : Figure.values()) {
				spanishDeck.add(new Card(s.value, f.value, 1));
			}
		}

		return spanishDeck;
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}

}

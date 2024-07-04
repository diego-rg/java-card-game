package escoba.deck;

import java.util.HashSet;
import java.util.Objects;

/**
 * Class that represents the spanish deck to play the game escoba
 */
public class Deck {

	/**
	 * Class that represents each individual card in the game
	 */
	class Card {
		private Suit suit;
		private Figure figure;
		private int value;
		private String symbol;

		/**
		 * @param suit   any of the four types of card in a set of playing cards
		 * @param figure any of the different elements from the same suit
		 * @param value  number that represents the value of a card
		 * @param symbol String that represents the abbreviation of the card's name
		 */
		public Card(Suit suit, Figure figure) {
			super();
			this.suit = suit;
			this.figure = figure;
			this.value = figure.getValue();
			this.symbol = "" + figure.getSymbol() + suit.getSymbol();
		}

		/**
		 * @return the suit
		 */
		public Suit getSuit() {
			return suit;
		}

		/**
		 * @return the figure
		 */
		public Figure getFigure() {
			return figure;
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @return the symbol
		 */
		public String getSymbol() {
			return symbol;
		}

		@Override
		public int hashCode() {
			return Objects.hash(symbol);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Card other = (Card) obj;
			return Objects.equals(symbol, other.symbol);
		}

		@Override
		public String toString() {
			return "Card " + symbol + "[suit=" + suit.name() + ", figure=" + figure + ", value=" + value + "]";
		}
	}

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

		for (Figure f : Figure.values()) {
			for (Suit s : Suit.values()) {
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

package escoba.card;

/**
 * Class that represents each individual card in the game
 */
public class Card {
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
	public String toString() {
		return "Card " + symbol + " [suit=" + suit.name() + ", figure=" + figure + ", value=" + value + "]";
	}
}
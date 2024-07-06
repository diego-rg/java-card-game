package escoba.card;

/**
 * Class that represents each individual card in the game
 */
public class Card {
	private Figure figure;
	private Suit suit;
	private int value;
	private String symbol;

	/**
	 * @param figure any of the different elements from the same suit
	 * @param suit   any of the four types of card in a set of playing cards
	 * @param value  number that represents the value of a card
	 * @param symbol String that represents the abbreviation of the card's name
	 */
	public Card(Figure figure, Suit suit) {
		super();
		this.figure = figure;
		this.suit = suit;
		this.value = figure.getValue();
		this.symbol = "" + figure.getSymbol() + suit.getSymbol();
	}

	/**
	 * @return the figure
	 */
	public Figure getFigure() {
		return figure;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
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
		return "Card " + symbol + " [figure=" + figure.getName() + ", suit=" + suit.getName() + ", value=" + value
				+ "]";
	}
}
package escoba.card;

/**
 * Enum that represents the suits of the spanish deck
 */
public enum Suit {
	COINS('o', "Coins"), CUPS('u', "Cups"), SWORDS('s', "Swords"), CLUBS('l', "Clubs");

	private final char symbol;
	private final String name;

	/**
	 * @param symbol char that represents the abbreviation of the name
	 * @param name   name of each suit
	 */
	private Suit(char symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}

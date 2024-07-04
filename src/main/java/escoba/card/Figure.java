package escoba.card;

/**
 * Enum that represents the figures of each suit in the spanish deck
 */
enum Figure {
	ACE('1', "Ace", 1), TWO('2', "Two", 2), THREE('3', "Three", 3), FOUR('4', "Four", 4), FIVE('5', "Five", 5),
	SIX('6', "Six", 6), SEVEN('7', "Seven", 7), VALET('V', "Valet", 8), CAVALIER('C', "Cavalier", 9),
	KING('K', "King", 10);

	private final char symbol;
	private final String name;
	private final int value;

	/**
	 * @param symbol char that represents the abbreviation of the name
	 * @param name   name of each suit
	 * @param value  numeric value of each symbol
	 */
	private Figure(char symbol, String name, int value) {
		this.symbol = symbol;
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the symbol
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

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

}

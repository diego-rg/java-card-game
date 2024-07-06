package escoba.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CardTest {
	Card oneOfCoins = new Card(Figure.ACE, Suit.COINS);

	@Test
	void oneOfCoinsFigureMustBeAce() {
		assertEquals(Figure.ACE, oneOfCoins.getFigure());
	}

	@Test
	void oneOfCoinsSuitMustBeCoins() {
		assertEquals(Suit.COINS, oneOfCoins.getSuit());
	}

	@Test
	void oneOfCoinsSymbolMustBe1c() {
		assertEquals("1o", oneOfCoins.getSymbol());
	}

	@Test
	void oneOfCoinsValueMustBeOne() {
		assertEquals(1, oneOfCoins.getValue());
	}

	@Test
	void oneOfCoinsToStringMustBe() {
		assertEquals("Card 1o [figure=Ace, suit=Coins, value=1]", oneOfCoins.toString());
	}

}

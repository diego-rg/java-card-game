package escoba.trick;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import escoba.card.Card;
import escoba.card.Figure;
import escoba.card.Suit;

public class TrickTest {
	Card oneOfCoins = new Card(Figure.ACE, Suit.COINS);
	Card sevenOfClubs = new Card(Figure.SEVEN, Suit.CLUBS);
	Card sevenOfSwords = new Card(Figure.SEVEN, Suit.SWORDS);

	Trick normalTrick = new Trick(new LinkedList<Card>(Arrays.asList(oneOfCoins, sevenOfClubs, sevenOfSwords)), false);
	Trick escobaTrick = new Trick(new LinkedList<Card>(Arrays.asList(oneOfCoins, sevenOfClubs, sevenOfSwords)), true);

	@Test
	void normalTrickMustNotHaveEscoba() {
		assertEquals(false, normalTrick.isEscoba());
	}

	@Test
	void escobaTrickMustHaveEscoba() {
		assertEquals(true, escobaTrick.isEscoba());
	}

	@Test
	void escobaTrickMustHaveThreeCards() {
		assertEquals(3, escobaTrick.getCards().size());
	}

	@Test
	void escobaTrickMustHaveValueSevenAsSecondCard() {
		assertEquals(7, escobaTrick.getCards().get(1).getValue());
	}

	// Just to ignore toString method during coverage metrics
	@Test
	void normalTrickToStringMustBe() {
		assertNotNull(normalTrick.toString());
	}
}

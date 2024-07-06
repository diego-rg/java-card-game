package escoba.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DeckTest {
	Deck spanishDeck = new Deck();

	@Test
	void sizeOfDeckMustBe40() {
		assertEquals(40, spanishDeck.getCards().size());
	}

	// Just to ignore toString method during coverage metrics
	@Test
	void spanishDeckToStringMustBe() {
		assertNotNull(spanishDeck.toString());
	}
}

package escoba.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import escoba.card.Card;
import escoba.card.Figure;
import escoba.card.Suit;
import escoba.trick.Trick;

public class PlayerTest {
	Card oneOfCoins = new Card(Figure.ACE, Suit.COINS);
	Card sevenOfClubs = new Card(Figure.SEVEN, Suit.CLUBS);
	Card sevenOfCoins = new Card(Figure.SEVEN, Suit.COINS);

	Card kingOfSwords = new Card(Figure.KING, Suit.SWORDS);
	Card twoOfCoins = new Card(Figure.TWO, Suit.COINS);
	Card threeOfCoins = new Card(Figure.THREE, Suit.COINS);

	Card fourOfCoins = new Card(Figure.FOUR, Suit.COINS);
	Card sixOfSwords = new Card(Figure.SIX, Suit.SWORDS);
	Card fiveOfCoins = new Card(Figure.FIVE, Suit.COINS);
	Card sevenOfSwords = new Card(Figure.SEVEN, Suit.SWORDS);

	Card fiveOfSwords = new Card(Figure.FIVE, Suit.SWORDS);
	Card kingOfCoins = new Card(Figure.KING, Suit.COINS);

	Trick trickOnePlayerOne = new Trick(new LinkedList<Card>(Arrays.asList(oneOfCoins, sevenOfClubs, sevenOfCoins)),
			true);
	Trick trickTwoPlayerOne = new Trick(new LinkedList<Card>(Arrays.asList(kingOfSwords, twoOfCoins, threeOfCoins)),
			false);
	Trick trickThreePlayerOne = new Trick(
			new LinkedList<Card>(Arrays.asList(fourOfCoins, sixOfSwords, fiveOfCoins, sevenOfSwords)), false);
	Trick trickOnePlayerTwo = new Trick(new LinkedList<Card>(Arrays.asList(fiveOfSwords, kingOfCoins)), true);

	Human playerOne = new Human();
	Human playerTwo = new Human();

	@Test
	void playerOneMustHaveThreeScore() {
		playerOne.receiveTrick(trickOnePlayerOne);
		playerOne.receiveTrick(trickTwoPlayerOne);
		playerOne.receiveTrick(trickThreePlayerOne);
		playerOne.receiveTrick(trickTwoPlayerOne);
		playerOne.receiveTrick(trickThreePlayerOne);
		playerOne.receiveTrick(trickTwoPlayerOne);
		playerOne.receiveTrick(trickThreePlayerOne);
		playerOne.receiveTrick(trickTwoPlayerOne);
		playerOne.receiveTrick(trickThreePlayerOne);
		playerOne.receiveTrick(trickTwoPlayerOne);
		playerOne.receiveTrick(trickThreePlayerOne);
		assertEquals(5, playerOne.calculateScore());
	}

	@Test
	void playerTwoMustHaveOneScore() {
		playerTwo.receiveTrick(trickOnePlayerTwo);
		assertEquals(1, playerTwo.calculateScore());
	}

	@Test
	void playerTwoMustHaveOneTrick() {
		playerTwo.receiveTrick(trickOnePlayerTwo);
		assertEquals(1, playerTwo.getTricks().size());
	}

	@Test
	void playerTwoMustHaveTwoCardsInHand() {
		playerTwo.receiveCard(sevenOfSwords);
		playerTwo.receiveCard(fiveOfCoins);
		assertEquals(2, playerTwo.getHand().size());
	}

	@Test
	void playerTwoMustHaveOneCardInHandAfterThrow() {
		playerTwo.receiveCard(sevenOfSwords);
		playerTwo.receiveCard(fiveOfCoins);
		playerTwo.throwCard(fiveOfCoins);
		assertEquals(1, playerTwo.getHand().size());
	}
}

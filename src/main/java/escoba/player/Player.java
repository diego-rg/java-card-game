package escoba.player;

import java.util.LinkedList;
import java.util.Objects;

import escoba.card.Card;
import escoba.card.Figure;
import escoba.card.Suit;
import escoba.trick.Trick;

/**
 * Abstract class that defines de base characteristics of a player in the game
 */
public abstract class Player {
	private int id;
	private LinkedList<Trick> tricks;
	private LinkedList<Card> hand;
	public static int totalPlayers = 0;

	/**
	 * 
	 */
	public Player() {
		super();
		totalPlayers++;
		this.id = totalPlayers;
		this.tricks = new LinkedList<Trick>();
		this.hand = new LinkedList<Card>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the totalPlayers
	 */
	public static int getTotalPlayers() {
		return totalPlayers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return id == other.id;
	}

	/**
	 * @return the tricks
	 */
	public LinkedList<Trick> getTricks() {
		return tricks;
	}

	/**
	 * @return the hand
	 */
	public LinkedList<Card> getHand() {
		return hand;
	}

	/**
	 * Adds the trick the player won to his tricks list
	 * 
	 * @param Trick trick that the player will receive after winning one turn by sum 15
	 */
	public void receiveTrick(Trick trick) {
		tricks.add(trick);
	}

	/**
	 * Adds the a new playable card to the player's hand
	 * 
	 * @param Card card that the player will receive and keep in his hand
	 */
	public void receiveCard(Card card) {
		hand.add(card);
	}

	/**
	 * Throws a card from player's hand to the table when he does not get a trick
	 * 
	 * @param Card card that the player will throw to the table if he cant sum 15 this turn
	 */
	public void throwCard(Card card) {
		hand.remove(card);
	}

	/**
	 * Calculates the score of the player after the game ends
	 * 
	 * @param int final score of the player when the game finishes: -Each escoba gives 1 point -The seven of coins gives
	 *            1 point -The player with more cards (21 or more) gets 1 point -The player with more coins (6 or more)
	 *            gets 1 point -The player with more sevens (3 or more) gets 1 point
	 */
	public int calculateScore() {
		int score = 0;
		int cards = 0;
		int coins = 0;
		int sevens = 0;
		for (Trick t : tricks) {
			if (t.isEscoba())
				score++;
			for (Card c : t.getCards()) {
				cards++;
				if (c.getSuit() == Suit.COINS)
					coins++;
				if (c.getFigure() == Figure.SEVEN)
					sevens++;
				if (c.getSymbol().equals("7o"))
					score++;
			}
		}
		if (cards > 20)
			score++;
		if (coins > 5)
			score++;
		if (sevens > 2)
			score++;
		return score;
	}

}

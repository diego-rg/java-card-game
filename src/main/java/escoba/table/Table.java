package escoba.table;

import java.util.LinkedList;

import escoba.card.Card;

/**
 * Class that represents the the cards that dont belong to the players
 */
public class Table {
	private LinkedList<Card> hand;
	private LinkedList<Card> stock;

	/**
	 * @param hand  LinkedList<Card> visible cards distributed on the table when the game starts
	 * @param stock LinkedList<Card> remaining hidden cards to be distributed later
	 */
	public Table() {
		super();
		this.hand = new LinkedList<Card>();
		this.stock = new LinkedList<Card>();
	}

	/**
	 * @return the hand
	 */
	public LinkedList<Card> getHand() {
		return hand;
	}

	/**
	 * @return the stock
	 */
	public LinkedList<Card> getStock() {
		return stock;
	}

	/**
	 * Adds a new playable card to the table
	 * 
	 * @param Card card that the table will receive after the card distribution when the game starts or when a player
	 *             throws it
	 */
	public void receiveCard(Card card) {
		hand.add(card);
	}

	/**
	 * Removes a card from the table after a player wins a trick
	 * 
	 * @param Card card that will dissapear from the table after a player makes a trick
	 */
	public void giveCard(Card card) {
		hand.add(card);
	}

}

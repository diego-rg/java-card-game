package escoba.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import escoba.card.Card;
import escoba.player.Bot;
import escoba.player.Human;
import escoba.player.Player;
import escoba.state.Observer;
import escoba.state.Subject;
import escoba.table.Table;

/**
 * Class that represents the game that is being played
 */
public class Game implements Subject {
	private HashMap<Integer, Player> players;
	private Table table;
	private Integer currentPlayer;
	private Player userWonLastTrick;
	private boolean isFinished;
	private ArrayList<Observer> observers;

	/**
	 * @param players
	 * @param table
	 * @param currentPlayer
	 * @param userWonLastTrick
	 * @param isFinished
	 * @param observers
	 */
	public Game() {
		super();
		this.players = new HashMap<Integer, Player>();
		this.table = new Table();
		this.currentPlayer = null;
		this.userWonLastTrick = null;
		this.isFinished = false;
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * @return the players
	 */
	public HashMap<Integer, Player> getPlayers() {
		return players;
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @return the currentPlayer
	 */
	public Integer getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @return the userWonLastTrick
	 */
	public Player getUserWonLastTrick() {
		return userWonLastTrick;
	}

	/**
	 * @return the isFinished
	 */
	public boolean isFinished() {
		return isFinished;
	}

	/**
	 * @return the observers
	 */
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	/**
	 * 
	 * 
	 */
	public Player getPlayerById(int id) {
		return players.get(id);
	}

	/**
	 * Starts the game. IMPORTANT: for now, it will be only a 1v1 game, human vs (throwCard)IA
	 * 
	 * @throws Exception when there are no enough cards to deal
	 */
	public void init() throws Exception {
		Human playerOne = new Human();
		Bot playerTwo = new Bot();
		addPlayer(playerOne.getId(), playerOne);
		addPlayer(playerTwo.getId(), playerTwo);
		shuffleDeck(table.getStock());
		dealCardsToTable();
		dealCardsToPlayers();
		currentPlayer = 1;
	}

	/**
	 * Adds one player to the game
	 * 
	 * @param Integer key of the player in the map
	 * @param Player  type of player created
	 */
	private void addPlayer(Integer key, Player player) {
		if (!players.containsKey(key)) {
			players.put(key, player);
		} else {
			throw new IllegalArgumentException("ERROR: The player with key '" + key + "' already exists!");
		}
	}

	/**
	 * Shuffles a list of cards
	 * 
	 * @param LinkedList<Card> cards;
	 */
	public void shuffleDeck(LinkedList<Card> cards) {
		Collections.shuffle(cards);
	}

	/**
	 * Deals 4 visible and playable cards to the table at the beginning of the game
	 * 
	 * @throws Exception when there are no enough cards to deal
	 */
	private void dealCardsToTable() throws Exception {
		if (table.getStock().size() >= 4) {
			for (int i = 0; i < 4; i++) {
				table.receiveCard(table.getStock().pollLast());
			}

		} else {
			throw new Exception("ERROR: No enough cards to deal!");
		}
	}

	/**
	 * Deals 3 cards to each player (at the start of the game and every time both players run out for cards in hand)
	 * 
	 * @throws Exception when there are no enough cards to deal
	 */
	private void dealCardsToPlayers() throws Exception {
		if (table.getStock().size() >= 6) {
			for (Player p : players.values()) {
				for (int i = 0; i < 3; i++) {
					p.receiveCard(table.getStock().pollLast());
				}
			}
		} else {
			throw new Exception("ERROR: No enough cards to deal!");
		}
	}

	/**
	 * Changes the current player after each turn
	 */
	public void changeCurrentPlayer() {
		currentPlayer = currentPlayer % players.size() + 1;
	}

	/**
	 * Manages the turn of each player after a card is played by changing the active player
	 * 
	 * @throws Exception if there are no enough cards to deal
	 */
	public void finishTurn() throws Exception {
		if (arePlayersOutOfCards() && table.getStock().size() < 1)
			isFinished = true;
		if (arePlayersOutOfCards())
			dealCardsToPlayers();
		currentPlayer = currentPlayer % players.size() + 1;
	}

	/**
	 * Checks if both players are out of cards to deal cards once more
	 */
	private boolean arePlayersOutOfCards() {
		for (Player p : players.values()) {
			if (p.getHand().size() > 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void subscribeObserver(Observer observer) {
		if (observer == null)
			throw new NullPointerException("Null Observer");
		if (!observers.contains(observer))
			observers.add(observer);
	}

	@Override
	public void unsubscribeObserver(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update();
		}
	}

}

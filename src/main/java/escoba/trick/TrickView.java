package escoba.trick;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import escoba.card.Card;
import escoba.card.CardView;
import escoba.player.Player;
import javafx.scene.layout.StackPane;

/**
 * Class that renders each card in the players hand
 */
public class TrickView {
	private Player model;
	private LinkedList<CardView> cards;
	private boolean isVisible;

	/**
	 * @param model
	 * @param cards
	 */
	public TrickView(Player model, boolean isVisible) {
		super();
		this.model = model;
		this.cards = new LinkedList<CardView>();
		this.isVisible = isVisible;
	}

	/**
	 * @return the model
	 */
	public Player getModel() {
		return model;
	}

	/**
	 * @return the cards
	 */
	public LinkedList<CardView> getCards() {
		return cards;
	}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible the isVisible to set
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * Creates the view of each card
	 * 
	 * @throws FileNotFoundException
	 */
	public void createViews() throws FileNotFoundException {
		for (Trick t : this.model.getTricks()) {
			for (Card c : t.getCards()) {
				this.cards.push(new CardView(c, isVisible));
			}
		}
	}

	/**
	 * Creates the views once again and renders the views of the hand
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	public void render(StackPane container) throws FileNotFoundException {
		createViews();
		for (CardView c : cards) {
			container.getChildren().add(c.getElement());
		}
	}
}
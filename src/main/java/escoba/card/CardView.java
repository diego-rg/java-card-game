package escoba.card;

import escoba.game.Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class that manages the view of a card to be rendered later inside a parent container
 */

public class CardView {
	private Card model;
	private boolean isVisible;
	private boolean isSelected;
	private String srcImg;
	private ImageView element;

	/**
	 * @param model
	 * @param isVisible
	 * @param isSelected
	 * @param srcImg
	 * @param element
	 */
	public CardView(Card model, boolean isVisible) {
		super();
		this.model = model;
		this.isVisible = isVisible;
		this.isSelected = false;
		if (isVisible)
			this.srcImg = "/img/cards/" + this.model.getSymbol() + ".png";
		else
			this.srcImg = "/img/cards/back.png";
		this.element = new ImageView(new Image(Game.class.getResourceAsStream(this.srcImg), 200, 200, true, false));
	}

	/**
	 * @return the model
	 */
	public Card getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Card model) {
		this.model = model;
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
	 * @return the isSelected
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected the isSelected to set
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * @return the srcImg
	 */
	public String getSrcImg() {
		return srcImg;
	}

	/**
	 * @param srcImg the srcImg to set
	 */
	public void setSrcImg(String srcImg) {
		this.srcImg = srcImg;
	}

	/**
	 * @return the element
	 */
	public ImageView getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(ImageView element) {
		this.element = element;
	}
}

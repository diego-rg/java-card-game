package escoba.state;

/**
 * Interface that represents a the hability of an object to notify its observers when its state changes
 */
public interface Subject {
	/**
	 * Adds a object to the list of the observers who will listen to the state of this subject object
	 * 
	 * @param Observer observer
	 */
	public void subscribeObserver(Observer observer);

	/**
	 * Removes a object from the list of the observers who will listen to the state of this subject object
	 * 
	 * @param Observer observer
	 */
	public void unsubscribeObserver(Observer observer);

	/**
	 * Notifies its observers when the state of the subject changes
	 */
	public void notifyObservers();
}

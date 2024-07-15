package escoba.state;

/**
 * Interface that represents a the hability of an object to update data based on the state of a subject
 */
public interface Observer {

	/**
	 * Updates the data when the subject notifies
	 */
	public void update();

}

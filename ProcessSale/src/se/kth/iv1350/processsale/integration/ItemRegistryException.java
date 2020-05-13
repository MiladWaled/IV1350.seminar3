package se.kth.iv1350.processsale.integration;

/**
 * Thrown when the database in the item registry can not be called. 
 * 
 *
 */
public class ItemRegistryException extends RuntimeException{
	
	/**
	 * Creates a new instance. 
	 * @param message The exception message. 
	 */
	public ItemRegistryException (String message) {
		super (message);
	}

}

package se.kth.iv1350.processsale.integration;

/**
 * Thrown when a search for an item identifier that does not 
 * exsist in the registry 
 *
 */
public class InvalidItemIDException extends Exception{
	String itemID; 
	
	/**
	 * Creates a new instance.
	 * @param ItemID The invalid item identifier 
	 */
	public InvalidItemIDException (String itemID) {
		super("The following item ID: " + itemID + " is invalid" );
		this.itemID = itemID;
	}
	
	/**
	 * Gets the invalid item identifier 
	 * @return the invalid item identifier
	 */
	public String getTheInvalidItemID () {
		return itemID;
	}

}

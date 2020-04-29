package se.kth.iv1350.processsale.integration;

/**
 * 
 * Represents an item with unique attributes. 
 *
 */
public class ItemDTO {
	private String itemID; 
	private String itemName; 
	private double VATRate;
	private double price; 
	private int quantity; 
	private boolean hasBeenScanned;
	 
	/**
	 * Creates a new instance representing a particular item. 
	 * @param itemName The name of the item. 
	 * @param itemID The unique item identifier for the item. 
	 * @param quantity The quantity of the item. 
	 * @param price The price of the unique item. 
	 * @param VATRate The VAT in % (of the price) for the item. 
	 */
	
	public ItemDTO(String itemName, String itemID, int quantity, double price, double VATRate ) {
		
		this.itemID = itemID; 
		this.itemName = itemName; 
		this.VATRate = VATRate; 
		this.price = price; 
		this.quantity = quantity;
		this.setHasBeenScanned (false);
		
	}
	
	public String getItemID() {
	return itemID;
	}
	
	public String getItemName() {
		return itemName; 
	}
	
	public double getPrice() {
		return price; 
	}

	public double getVATRate() {
		return VATRate; 
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Increases the quantity of the specified item by one. 
	 */
	public void addQuantity ()
	{
		this.quantity +=  1;
	}
	
	
	
	public boolean isScanned () 
	{
		return hasBeenScanned;
	}
	
	/**
	 * Used when an item is scanned for the first time. 
	 * @param hasBeenScanned Should be <code>true</code> only when an item is scanned for the
	 * first time. 
	 */
	public void setHasBeenScanned (boolean hasBeenScanned)
	{
		this.hasBeenScanned = hasBeenScanned;
	}
	
	/**
	 * Contains a string about the specified item with the attributes needed. 
	 * @return A string with the <code>itemName, quantity
	 * and price</code>. 
	 */
	@Override
	public String toString ()
	{
		return itemName + " | Quantity: " + quantity + " | Price with tax: " + (price + (price * VATRate)/100) + "\n";  
	}
	
}

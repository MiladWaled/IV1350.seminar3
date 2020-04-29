package se.kth.iv1350.processsale.integration;

import java.util.ArrayList;
/**
 * 
 * Contains all the calls to the data store with items that 
 * may be bought in the store. 
 *
 */

public class ItemRegistry {
	
	ArrayList <ItemDTO> itemList = new ArrayList <ItemDTO>();
	
	ItemRegistry(){
	addItems();
	}
	
	
	private void addItems () {
		itemList.add (new ItemDTO ("Banana", "1234", 1, 10, 20));
		itemList.add (new ItemDTO ("Apple", "1235", 1, 5, 20));
		itemList.add (new ItemDTO ("Bread", "1236", 1, 25, 10));
		itemList.add (new ItemDTO ("Meat", "1237", 1, 100 ,25));
		
	}
	/**
	 * Checks if the item identifier is in the register. 
	 * @param itemID The unique item identifier of a specific item.  
	 * @return A string depending on if the item is not already registered
	 * in the sale or not or if the item identifier is not found in the registry. 
	 */
	public  String checkItem (String itemID) {
		
		for (ItemDTO item: itemList) {
			if (itemID.equals(item.getItemID()) && item.isScanned()) {
				return "itemAlreadyRegistered";
			}
			
			if (itemID.equals(item.getItemID())) {
				item.setHasBeenScanned(true);
				return "OK"; 
			}
			
		}
		return "itemNotIdentified";

	
	}
	/**
	 * Contains the information about an item, such as price 
	 * VAT rate and name. 
	 * @param itemID The unique item identifier of a specific item.  
	 * @param quantity The quantity of that item. 
	 * @return An item with it's description, such as name,
	 * price and VAT rate or null if the item dosen't exist. 
	 */
	public ItemDTO retriveItemInfo(String itemID, int quantity) {
		for (ItemDTO item: itemList) {
			if (itemID.equals(item.getItemID())){
				item.setQuantity(quantity);
				return item;
				
			}
	}
		return null;

}
}
	

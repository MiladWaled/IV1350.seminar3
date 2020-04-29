package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Sale;

/**
 * Represents an external dummy inventory system since the external systems are omitted in this task. 
 *
 */

public class InventorySystem {
	
	/**
	 * Does nothing since the external systems are omitted in this task. 
	 * @param sale The completed sale that the inventory should be updated with. 
	 */
	
	public void updateInventory(Sale sale) {
		System.out.println ("The inventory has been updated with the sale \n");
	}

}

package se.kth.iv1350.processsale.integration;

/**
 * Creates an object for the external systems that are needed for the sale. 
 *
 */
public class ExternalSystemHandler {
	private InventorySystem invSys; 
	private AccountingSystem accSys; 
	
	/**
	 * Creates a new handler for the external systems. 
	 */
	public  ExternalSystemHandler() {
		invSys = new InventorySystem();
		accSys = new AccountingSystem(); 
		
	}

	/**
	 * Gets the content of the accounting system.
	 * @return The contents of the accounting system.
	 */
	public AccountingSystem getAccSys() {
		return accSys;
	}
	
	/**
	 * Gets the content of the inventory system.
	 * @return The contents of the inventory system.
	 */
	public InventorySystem getInvSys() {
		return invSys;
	}
	
	
}


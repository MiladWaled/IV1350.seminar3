package se.kth.iv1350.processsale.integration;

/**
 * Represents a handler for all the registers. The discount register was omitted. 
 *
 */
public class RegistryHandler {
	

	private ItemRegistry itemReg; 
	
	/**
	 * Creates a new instance. 
	 */
	public RegistryHandler () {
		itemReg = new ItemRegistry();
	}
	
	
	public ItemRegistry getItemReg() {
		return itemReg;
	}

}

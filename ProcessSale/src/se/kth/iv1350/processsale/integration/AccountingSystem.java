package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Sale;

/**
 * Represents an external dummy accounting system since the external systems are omitted in this task. 
 *
 */

public class AccountingSystem {
	
	/**
	 * Does nothing since the external systems are omitted in this task. 
	 * @param sale The completed sale that should be booked in the system. 
	 */
	public void bookKeepSale(Sale sale) {
		System.out.println("Sale has been accounted. \n");
	}

}

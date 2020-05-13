package se.kth.iv1350.processsale.integration.discount;

/**
 * Defines the ability to get a specific discount. This interface 
 * should be implemented by a class that provides a discount algorithm.  
 *
 */
public interface Discounter {
	
	/**
	 * Searches for a discount for a customer. 
	 * @param id The customer identification number. 
	 * @param amountToPay The total cost of the sale. 
	 * @return A discount based on the identification number or the cost of the sale. 
	 */

	public Discount getDiscount (String id, double amountToPay);
}

package se.kth.iv1350.processsale.integration.discount;

import java.util.HashMap;

/**
 * A systme that handles discount for specific customers based 
 * on thier customer identification number. 
 *
 */
 class CustomerIDDiscount implements Discounter{

	private HashMap<String, Discount> elligibleID = new HashMap<String, Discount>();
 
	/**
	 * Creates a new instance containing hardcoded customer identification numbers with 
	 * different discounts
	 */
	 CustomerIDDiscount() {
		elligibleID.put(new String("199606131234"), new Discount (0.2));
		elligibleID.put(new String("199001012233"), new Discount (0.3));
		elligibleID.put(new String("199202021122"), new Discount (0.4));
		
		
	}
	
	/**
	 * Searches for a discount depending on the customer identification number.
	 */
	public Discount getDiscount(String id, double amountToPay) {
		if (elligibleID.containsKey(id)){
				return (elligibleID.get(id));
		}
		return new ItemDiscount().getDiscount(id, amountToPay);
		
		
	}
	
	

}

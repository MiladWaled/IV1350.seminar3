package se.kth.iv1350.processsale.integration.discount;


public class ItemDiscount implements Discounter{

	private final double NO_DISCOUNT = 0.0;
	
	ItemDiscount (){
		
	}
 
	/**
	 * Searches for a discount depending on the total cost of the sale. 
	 */
	@Override
	public Discount getDiscount(String id, double amountToPay) {
		if (amountToPay > 200 && amountToPay < 500) {
			return new Discount (0.1);
		}
		if (amountToPay > 500) {
			return new Discount (0.2);
		}
		return new Discount (NO_DISCOUNT);
	}

}

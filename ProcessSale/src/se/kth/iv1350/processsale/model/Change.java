package se.kth.iv1350.processsale.model;

/**
 * Represents the change that should be given to the 
 * customer after that the payment is made. 
 *
 */
public class Change {
	private double amount; 
	
	/**
	 * Creates a new instance. 
	 * @param amountToPay The total price of the purchase, including tax. 
	 * @param amountPaid The amount paid by the customer. 
	 */
	public Change (double amountToPay, Payment amountPaid) {
		this.amount = amountPaid.getAmount() - amountToPay;
	}

	public double getAmount () {
		return amount; 
	}
}

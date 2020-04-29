package se.kth.iv1350.processsale.model;

/**
 * Represent a payment made by a customer for a 
 * specific sale. 
 *
 */
public class Payment {
	
	private double amount; 
	
	/**
	 * Creates a new instance. 
	 * @param amountPaid The amount paid by the customer. 
	 */
	public Payment (double amountPaid) {
		this.amount = amountPaid; 
	}

	public double getAmount() {
		return amount;
	}
}

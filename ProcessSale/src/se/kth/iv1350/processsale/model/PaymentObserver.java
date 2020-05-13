package se.kth.iv1350.processsale.model;

/**
 * A listener interface for receiving notifications every time a customer makes a new 
 * payment. All classes that are interested in such notification must implements 
 * this interface. When a payment is maid the objekt's method is invoked. 
 * 
 */
public interface PaymentObserver {

	/**
	 * Invoked when a payment has been maid. 
	 * @param amountPaid The amount paid of the customer. 
	 */
	void addPayment (Payment amountPaid);
}

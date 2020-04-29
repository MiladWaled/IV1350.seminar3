package se.kth.iv1350.processsale.model;

/**
 * Represents a dummy cash register with the balance in it. 
 *
 */
public class CashRegister {

	private double balance; 
	
	/**
	 * Creates a new instance. 
	 */
	public CashRegister () {
		this.balance = 0;
	}
	
	public double getBalance () {
		return balance;
	}
	
	/**
	 * Updates the balance in the register with the payment made 
	 * by the customer. 
	 * @param amountPaid The payment made by the customer. 
	 */
	public void updateBalance (Payment amountPaid) {
		balance = balance + amountPaid.getAmount();	
	}
}

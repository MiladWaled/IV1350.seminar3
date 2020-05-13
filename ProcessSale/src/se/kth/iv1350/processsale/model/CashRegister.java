package se.kth.iv1350.processsale.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dummy cash register with the balance in it. 
 *
 */
public class CashRegister {

	private double balance; 
	private List <PaymentObserver> paymentObservers = new ArrayList<>();
	
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
		notifyObservers(amountPaid);
		
	}
	
	private void notifyObservers (Payment amountPaid)
	{
		for (PaymentObserver obs: paymentObservers)
			obs.addPayment(amountPaid);
	}
	
	/**
	 * All the specified observers will be notified when a payment has been maid
	 * @param observers The observers to notify.
	 */
	public void addPaymentObservers (List <PaymentObserver> observers) {
		paymentObservers.clear();
		paymentObservers.addAll(observers);
	}
}

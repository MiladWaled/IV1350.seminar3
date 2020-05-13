package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.model.Payment;
import se.kth.iv1350.processsale.model.PaymentObserver;

/**
 * Shows the total revenue for all sales. 
 *
 */

public class TotalRevenueView  implements PaymentObserver {

	private double totalPayment;
	
	/**
	 * creates a new instance with the amount paid after each sale. 
	 */
	public void addPayment(Payment amountPaid) {
		totalPayment += amountPaid.getAmount();
		printCurrentRevenue();
		
	}
	
	private void printCurrentRevenue() {
		System.out.println("\n****** DISPLAY ******");
		System.out.println("*** REVENUE ***");
		System.out.println("Total amount: " +totalPayment);
		System.out.println("*********************\n");


	}

}

package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.controller.Controller;

/**
 * This is not an actual view. This class represents a placeholder 
 * for a view that can run a fake execution.
 *
 */

public class View {
	private Controller contr; 
	
	/**
	 * Creates a new instance. 
	 * @param contr The class where all calls are being made. 
	 */
	public View (Controller contr) {
		this.contr = contr; 
	}

	/**
	 * Represents "fake" inputs to the application by running 
	 * a sample execution of the application.
	 */
	public void sampleExecution()
	{
		contr.startNewSale();
		System.out.println("A new sale has started"); 
		contr.scanItem("1234", 1);
		contr.scanItem("1235", 1);
		contr.scanItem("1234", 1);
		contr.scanItem("1236", 2);
		contr.scanItem("1237", 1);
		contr.endSale();
		contr.makePayment(500);
		contr.printReciept();


	}
}

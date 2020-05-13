package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Receipt;

/**
 * Represents a dummy printer. 
 *
 */
public class Printer {
	private static final Printer PRINTER = new Printer();
	private Receipt receiptOfSale; 

	private Printer () {
		
	}

	public static Printer getPrinter() {
		return PRINTER;
	}
	
	/**
	 * Prints the receipt of the specific sale. 
	 * @param receiptOfSaleToPrint The receipt of 
	 * the sale that should be printed. 
	 */
	public void printReceipt(Receipt receiptOfSaleToPrint) {
		this.receiptOfSale = receiptOfSaleToPrint; 
		System.out.println(receiptOfSale.toString());
	}
}

package se.kth.iv1350.processsale.view;

import java.io.IOException;


import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.InvalidItemIDException;
import se.kth.iv1350.processsale.util.LogHandler;

/**
 * This is not an actual view. This class represents a placeholder 
 * for a view that can run a fake execution.
 *
 */

public class View {
	private Controller contr; 
	private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
	private LogHandler logHandler;
	
	/**
	 * Creates a new instance. 
	 * @param contr The class where all calls are being made. 
	 * @throws IOException 
	 */
	public View (Controller contr) throws IOException {
		this.contr = contr; 
		this.logHandler = new LogHandler();
		contr.addPaymentObserver(new TotalRevenueView( ));
	}

	/**
	 * Represents "fake" inputs to the application by running 
	 * a sample execution of the application.
	 */
	public void sampleExecution() 
	{
		contr.startNewSale();
		System.out.println("A new sale has started"); 
		scanItem("1234", 1);
		scanItem("1235", 1);
		scanItem("1234", 1);
		scanItem("1236", 2);
		scanItem("1237", 1);
		scanItem("CRASH", 2);
		scanItem("1121", 2);
		contr.endSale();
		contr.checkForDiscount("199202021122", contr.endSale());
		contr.makePayment(500);
		contr.printReciept();

	

	}
	
	private void scanItem(String itemID, int quantity) {
		
		try {
			 contr.scanItem(itemID, quantity);
		} catch (InvalidItemIDException exc) {
				handleException("Item ID: " +exc.getTheInvalidItemID() + " is not found in the registry. ", exc);

		} catch (Exception exc) {
			handleException("Servers are down, please try again. ", exc);
			
			}
	}
	
	private void handleException(String msg, Exception exc) {
		errorMsgHandler.showErrorMessage(msg);
		logHandler.logException(exc);
		
	}
}

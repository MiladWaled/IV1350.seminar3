package se.kth.iv1350.processsale.controller;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.processsale.integration.AccountingSystem;
import se.kth.iv1350.processsale.integration.ExternalSystemHandler;
import se.kth.iv1350.processsale.integration.InvalidItemIDException;
import se.kth.iv1350.processsale.integration.InventorySystem;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.ItemRegistry;
import se.kth.iv1350.processsale.integration.ItemRegistryException;
import se.kth.iv1350.processsale.integration.Printer;
import se.kth.iv1350.processsale.integration.RegistryHandler;
import se.kth.iv1350.processsale.model.CashRegister;
import se.kth.iv1350.processsale.model.Change;
import se.kth.iv1350.processsale.model.Payment;
import se.kth.iv1350.processsale.model.PaymentObserver;
import se.kth.iv1350.processsale.model.Sale;

/**
 * This is the application's only controller class. All calls to the model passes through here.
 * 
 *
 */
public class Controller {
	private Sale sale; 
	private AccountingSystem accSys; 
	private InventorySystem invSys; 
	private ItemRegistry itemReg; 
	private Printer printer; 
	private CashRegister cashRegister; 
	private List <PaymentObserver> paymentObservers = new ArrayList<>();

	/**
	 * Creates a new instance. 
	 * @param printer Interface to printer. 
	 * @param regHandler Used to get all classes that handle database calls.  
	 * @param exSysHandler Used to get all classes that handle external systems.
	 */
	
	public Controller (Printer printer, RegistryHandler regHandler, ExternalSystemHandler exSysHandler) {
		this.accSys = exSysHandler.getAccSys();
		this.invSys = exSysHandler.getInvSys();
		this.itemReg = regHandler.getItemReg();
		this.printer = printer; 
		this.cashRegister = new CashRegister();
	}
	
	/**
	 * Starts a new sale
	 */
	public void startNewSale () {
		sale = new Sale();
	}
	
	/**
	 * Handles different scenarios when an item is scanned. Also updates the sale with the specified item. 
	 * @param itemID Represents an item identifier for an item. 
	 * @param quantity Represents the quantity of the item. 
	 * @return A string containing information about the scanned item, if the {@link itemID} exists. 
	 * @throws InvalidItemIDException if the item identifier is not found in the registry
	 */
	public String scanItem (String itemID, int quantity) throws InvalidItemIDException, OperationFaildException
	{
		try {
		ItemDTO item = null;
		String itemInfo = ""; 
		String itemStatus = itemReg.checkItem(itemID);
		
		if (itemStatus.equals("OK")){
			item = itemReg.retriveItemInfo (itemID, quantity);	
			itemInfo = sale.updateSale(item);
			return itemInfo;
		}
		if (itemStatus.equals("itemAlreadyRegistered")){
			sale.addQuantity(itemID);
		}
		
		return itemInfo;
		} catch (ItemRegistryException exc) {
			throw new OperationFaildException ("Servers are down", exc);
		}
		
}
	/**
	 * Ends the current sale. 
	 * @return The total price for the sale, including tax. 
	 */
	public double endSale() {
	return sale.getAmountToPay();

	
	}	
	/**
	 * Checks if there is any discounts for the specified customer.
	 * @param id The customer identification number. 
	 * @param amountToPay The total cost of the sale 
	 * @return A discount based on the customer identification number or the total cost of the sale. 
	 */
	public double checkForDiscount (String id, double amountToPay ) {
		return sale.applyDiscount(id, amountToPay);
	}
	/**
	 * Makes a payment with the given {@link amount}. Updates the external systems and adds the 
	 * given {@link Amount} to the cash register. 
	 * @param amount The amount paid by the customer. 
	 * @return The change after that the transaction is completed. 
	 */
	public Change makePayment(double amount) {
		Payment amountPaid = new Payment(amount);
		cashRegister.addPaymentObservers(paymentObservers);
		cashRegister.updateBalance(amountPaid);
		Change change = sale.completeSale(amountPaid, invSys, accSys);
		return change;
		
	}
	
	/**
	 * Prints out the receipt of the sale. 
	 */
	
	public void printReciept () {
		sale.printReceipt(printer);
	}
	
	public void addPaymentObserver(PaymentObserver obs) {
		paymentObservers.add(obs);
	}
}	

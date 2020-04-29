package se.kth.iv1350.processsale.controller;

import se.kth.iv1350.processsale.integration.AccountingSystem;
import se.kth.iv1350.processsale.integration.ExternalSystemHandler;
import se.kth.iv1350.processsale.integration.InventorySystem;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.ItemRegistry;
import se.kth.iv1350.processsale.integration.Printer;
import se.kth.iv1350.processsale.integration.RegistryHandler;
import se.kth.iv1350.processsale.model.CashRegister;
import se.kth.iv1350.processsale.model.Change;
import se.kth.iv1350.processsale.model.Payment;
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
	 */
	public String scanItem (String itemID, int quantity)
	{
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
		if (itemStatus.equals("itemNotIdentified"))
			itemInfo = "Wrong item ID";

		
		return itemInfo;
}
	/**
	 * Ends the current sale. 
	 * @return The total price for the sale, including tax. 
	 */
	public double endSale() {
	return sale.getAmountToPay();
	}	
	
	/**
	 * Makes a payment with the given {@link amount}. Updates the external systems and adds the 
	 * given {@link Amount} to the cash register. 
	 * @param amount The amount paid by the customer. 
	 * @return The change after that the transaction is completed. 
	 */
	public Change makePayment(double amount) {
		Payment amountPaid = new Payment(amount);
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
}	

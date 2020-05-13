package se.kth.iv1350.processsale.model;

import java.time.LocalTime;

import java.util.ArrayList;

import se.kth.iv1350.processsale.integration.AccountingSystem;
import se.kth.iv1350.processsale.integration.InventorySystem;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.Printer;
import se.kth.iv1350.processsale.integration.discount.DiscounterFactory;

/**
 * Represents a sale between a customer and the store.  
 *
 */
public class Sale {
	private LocalTime saleTime; 
	private double totalPrice; 
	private Payment amountPaid; 
	private double totalVAT; 
	private Change change; 
	private ArrayList <ItemDTO> itemsPurchased = new ArrayList<ItemDTO>();
	private Receipt receiptOfSale; 
	private double totalAfterDiscount;
	
	/**
	 * creates a new instance.  
	 */
	public Sale ()
	{
		this.saleTime = LocalTime.now();
		this.totalPrice = 0;
		this.totalVAT = 0;
		this.totalAfterDiscount = 0;
		
	}

	/**
	 * Updates the sale by adding the unique item to the list 
	 * of items purchased. Updates also the total price for the sale 
	 * including tax. 
	 * @param item The specific item that should be added to the sale.
	 * @return A string representing the items that have been bought. 
	 */
	public String updateSale (ItemDTO item) {
		itemsPurchased.add(item);
		updatePrice(item);
		updateVAT(item);
		return itemsPurchased.toString();
		
	}
	
	private void updatePrice (ItemDTO item) {
		totalPrice = getTotalPrice() + (item.getQuantity() * item.getPrice());
	}
	
	private void updateVAT(ItemDTO item) {
		totalVAT = getTotalVAT() + (item.getQuantity() * item.getPrice() * (item.getVATRate()/100));
		
	}
	
	private void updatePriceAndVATForRegisteredItem(ItemDTO item) {
		totalPrice -= ((item.getQuantity() - 1) * item.getPrice());
		
		totalVAT -= ((item.getQuantity() - 1) * item.getPrice() * (item.getVATRate()/100));
			
		
	}

	/**
	 * Increases the quantity of a specific item if it has been 
	 * scanned before.  
	 */
	public void addQuantity (String ItemID) {
		ItemDTO updatedItem = null;
		for (ItemDTO item : itemsPurchased) {
			if (ItemID.equals(item.getItemID())) {
				item.addQuantity();
				updatedItem = item;
			}	
		}
		itemsPurchased.remove(updatedItem);
		updateSale(updatedItem);
		updatePriceAndVATForRegisteredItem(updatedItem);
		
	}
	/**
	 * Applies discount for specific customer. 
	 * @param id The customer's identification number.
	 * @param amountToPay Total cost of the sale 
	 * @return
	 */
	public double applyDiscount (String id, double amountToPay) {
		DiscounterFactory factory = DiscounterFactory.getFactory();
		double discountRate = (factory.getDefaultDiscount().getDiscount(id, amountToPay).getDiscountRate());
		totalAfterDiscount = (getAmountToPay()) - (getAmountToPay()) * (discountRate);
		return totalVAT + totalPrice;
	}
	/**
	 * Completes the sale by updating the external systems and 
	 * returning the change (if any) to the customer. 
	 * @return the change after that the payment is made. 
	 */
	public Change completeSale(Payment amountPaid, InventorySystem invSys, AccountingSystem accSys) {
		this.amountPaid = amountPaid; 
		this.change = new Change (totalAfterDiscount, amountPaid);
		updateExternalSystems(invSys, accSys);
		return change;
	}
	
	private void updateExternalSystems(InventorySystem invSys, AccountingSystem accSys) {
		invSys.updateInventory(this);
		accSys.bookKeepSale(this);
	}
	
	/**
	 * Prints the receipt of the sale. 
	 * @param printer The printer that prints the receipt. 
	 */
	public void printReceipt (Printer printer) {
		this.receiptOfSale = new Receipt (this);
		printer.printReceipt(receiptOfSale);
	}
	
	public double getTotalPrice () {
		return totalPrice;
	}
	
	
	
	public double getTotalVAT () {
		return totalVAT;
	}
	
	public LocalTime getSalesTime() {
		return saleTime;
	}
	
	public double getAmountToPay() {
		return getTotalPrice() + getTotalVAT();
	}
	
	private String getItemsBought () {
		StringBuilder itemsBought = new StringBuilder();
		for (ItemDTO item : itemsPurchased)
			itemsBought.append(item.toString());
		return itemsBought.toString();
	}
	
	
	private double getQuantity() {
		int quantity = 0; 
		for (ItemDTO item: itemsPurchased)
			quantity +=item.getQuantity();
		return quantity;
	}
	
	/**
	 * Transforms the sale object to a string containing all 
	 * the information about the sale. 
	 * @return A string with information about the specific sale. 
	 */
	public String toString () {
		StringBuilder saleInfo = new StringBuilder();
		addLine(saleInfo, "Time for the sale; " + saleTime);
		addLine(saleInfo, "Number of items bought: " + getQuantity());
		addLine(saleInfo, "Info about items bought: " + getItemsBought());
		addLine(saleInfo, "Total amount to pay: " + getAmountToPay());
		addLine(saleInfo, "Total amount to pay after discount applied: " + totalAfterDiscount);
		addLine(saleInfo, "Amount paid: " + amountPaid.getAmount());
		addLine (saleInfo, "Change: " + change.getAmount());
		return saleInfo.toString();
		
	}
	
	private void addLine (StringBuilder builder, String line) {
		builder.append(line);
		builder.append("\n");
	}
}

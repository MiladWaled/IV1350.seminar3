package se.kth.iv1350.processsale.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import se.kth.iv1350.processsale.integration.ItemDTO;

class ChangeTest {

	

	@Test
	void TestChange() {
		double price = 20;
		double VATRate = 10; 
		String itemID = "1221";
		String itemName = "Book";
		int quantity = 2; 
		ItemDTO item = new ItemDTO(itemName, itemID, quantity, price, VATRate);
		double totalPrice = item.getQuantity() * item.getPrice();
		totalPrice +=  item.getQuantity() * item.getPrice() * (item.getVATRate()/100);
		Payment amountPaid = new Payment (200);
		Change change = new Change (totalPrice, amountPaid);
		double expectedResult = amountPaid.getAmount() - totalPrice; 
		double actualResult = change.getAmount();
		assertEquals (actualResult,expectedResult, "The amount of change is not the same");
		
		
	}
	

}

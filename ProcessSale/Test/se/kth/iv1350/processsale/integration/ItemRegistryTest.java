package se.kth.iv1350.processsale.integration;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ItemRegistryTest {

	
	@Test
	void testInvalidItemID() {
		ItemRegistry instance = new ItemRegistry();
		String itemID = "5555";
		
		try {
			instance.checkItem(itemID);
			fail ("Could find the invalid item ID in the registry ");
		} catch (InvalidItemIDException exc) {
			assertTrue(exc.getMessage().contains(itemID), "The message contains wrong information:  ");
			assertTrue(exc.getTheInvalidItemID().contentEquals(itemID), "Wrong item is specificed");
			
		}
	}
	
	@Test
	void testWhenDatabaseCanNotBeCalled() {
		ItemRegistry instance = new ItemRegistry();
		String itemID = "CRASH";
		
		try {
			instance.checkItem(itemID);
			fail ("The database can be called although the server is down ");
		} catch (Exception exc) {
			assertTrue(exc.getMessage().contains("not running"), "The message contains wrong information:  ");
		}
	}

}

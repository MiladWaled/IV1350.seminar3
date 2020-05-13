package se.kth.iv1350.processsale.integration.discount;

/**
 * A singleton that creates instances of the algorithm used to find 
 * discounts. All such instances must implement <code>Discounter</code>.
 *
 */
public class DiscounterFactory {
	private static final DiscounterFactory INSTANCE = new DiscounterFactory();
	private Discounter defaultDiscounter = new CustomerIDDiscount();
	
	private DiscounterFactory() {	
	}
	
	/**
	 * 
	 * @return The only instance of the Singleton
	 */
	public static DiscounterFactory getFactory() {
		return INSTANCE;
	}
	public Discounter getDefaultDiscount() {
	return defaultDiscounter;
	}

}

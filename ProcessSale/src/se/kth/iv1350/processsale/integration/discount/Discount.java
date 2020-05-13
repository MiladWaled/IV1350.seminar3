package se.kth.iv1350.processsale.integration.discount;

public class Discount {
	private double discountRate;
	
	public Discount (double discountRate) {
		this.discountRate = discountRate;
	}
	
	public double getDiscountRate () {
		return discountRate;
	}

}

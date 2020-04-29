package se.kth.iv1350.processsale.model;

/**
 * Represent a receipt. 
 *
 */
public class Receipt {

	private Sale sale; 
	
	/**
	 * Creates a new instance, represented as a receipt. 
	 * @param sale The specific sale that is used to print 
	 * the receipt. 
	 */
	public Receipt (Sale sale) {
	this.sale = sale; 
	}
	
	/**
	 * Creates a representation of an actual receipt with the information 
	 * about the purchase that is made by a customer. 
	 */
	public String toString() {
		StringBuilder receipt = new StringBuilder();
		addLine(receipt, "________ Receipt_______");
		addLine(receipt, "Your sale: ");
		addLine(receipt, sale.toString());
		addLine(receipt, "Thank you for shopping with us");
		return receipt.toString();
	}
	
	private void addLine(StringBuilder builder, String line) {
		builder.append(line);
		builder.append("\n");
	}
}


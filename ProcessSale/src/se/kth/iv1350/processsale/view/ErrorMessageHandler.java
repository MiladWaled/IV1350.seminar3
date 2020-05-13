package se.kth.iv1350.processsale.view;

import java.time.LocalDateTime;

/**
 * 
 * Handles all messages for the cashier. 
 */

  class ErrorMessageHandler {
	
	  
	
	  /**
	   * A method that creates a message for the cashier.
	   * @param msg The messaged that is show for the cashier. 
	   */
	void showErrorMessage (String msg)
	{
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("\n");
		errorMessage.append("-------- ERROR FOR THE CASHIER -----------");
		errorMessage.append("\n");
		errorMessage.append(getCurrentTime());
		errorMessage.append(" ERROR: ");
		errorMessage.append(msg);
		errorMessage.append("\n");
		errorMessage.append("------------------------------------------");
		System.out.println(errorMessage);


	}
	
	private String getCurrentTime() {
		StringBuilder builder = new StringBuilder();
		LocalDateTime current = LocalDateTime.now();
		builder.append("Date: " +current.toLocalDate());
		builder.append("\n");
		builder.append("Time: " + current.toLocalTime());
		return builder.toString();
	}
}

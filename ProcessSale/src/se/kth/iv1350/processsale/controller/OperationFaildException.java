package se.kth.iv1350.processsale.controller;

/**
 * Thrown when an operations fails and the cause may be unknown. 
 *
 */
public class OperationFaildException extends Exception {
	
	/**
	 * Creates a new instance with a specific message and the root cause.
	 * @param msg The exception message
	 * @param cause The exceptions that caused this exception. 
	 */
	
	public OperationFaildException (String msg, Exception cause) {
		super (msg, cause);

	}

}

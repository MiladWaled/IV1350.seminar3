package se.kth.iv1350.processsale.startup;



import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.ExternalSystemHandler;
import se.kth.iv1350.processsale.integration.Printer;
import se.kth.iv1350.processsale.integration.RegistryHandler;
import se.kth.iv1350.processsale.view.View;

/**
 * Contains the main method. Performs all startup 
 * of the application.
 */
public class Main {

	/**
	 * Starts the application.
	 * @param args The application does not take any 
	 * command line parameters. 
	 */
	public static void main(String[] args) {
		Printer printer = new Printer();
		RegistryHandler regHandler = new RegistryHandler();
		ExternalSystemHandler exSysHandler = new ExternalSystemHandler();
		Controller contr = new Controller(printer, regHandler, exSysHandler); 
		View view = new View(contr); 
		view.sampleExecution();
		

	}

}

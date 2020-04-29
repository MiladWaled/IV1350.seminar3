package se.kth.iv1350.processsale.view;

import static org.junit.jupiter.api.Assertions.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.ExternalSystemHandler;
import se.kth.iv1350.processsale.integration.Printer;
import se.kth.iv1350.processsale.integration.RegistryHandler;


class ViewTest {
	private View instanceToTest;  
	private ByteArrayOutputStream printoutBuffer; 
	private PrintStream originalSysOut; 
	@BeforeEach
	void setUp()  {
		Printer printer = new Printer();
		RegistryHandler regHandler = new RegistryHandler();
		ExternalSystemHandler exSysHandler = new ExternalSystemHandler();
		Controller contr = new Controller (printer, regHandler, exSysHandler); 
		instanceToTest = new View (contr); 
		printoutBuffer = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream (printoutBuffer);
		originalSysOut = System.out;
		System.setOut(inMemSysOut);
	}

	@AfterEach
	void tearDown() {
		instanceToTest = null; 
		
		printoutBuffer = null; 
		System.setOut(originalSysOut);
		
	}

	@Test
	void testRunFakeExecution() {
		instanceToTest.sampleExecution();
		
		String printout = printoutBuffer.toString();
		String excpectedOutput = "started";
		assertTrue(printout.contains(excpectedOutput), "A new sale failed to start");
	}

}

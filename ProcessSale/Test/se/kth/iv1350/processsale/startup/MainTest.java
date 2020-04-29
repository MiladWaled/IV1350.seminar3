package se.kth.iv1350.processsale.startup;

import static org.junit.jupiter.api.Assertions.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MainTest {
	
	private ByteArrayOutputStream printoutBuffer; 
	private PrintStream originalSysOut; 
	
	@BeforeEach
	void setUp()  {
		
		printoutBuffer = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream (printoutBuffer);
		originalSysOut = System.out;
		System.setOut(inMemSysOut);
	}

	@AfterEach
	void tearDown() {
		
		printoutBuffer = null; 
		System.setOut(originalSysOut);
		
	}


	
	@Test
	void test() {
		String [] args = null; 
		Main.main(args);
		
		String printout = printoutBuffer.toString();
		String excpectedOutput = "started";
		assertTrue(printout.contains(excpectedOutput), "A new sal failed to start");
		
	}

}

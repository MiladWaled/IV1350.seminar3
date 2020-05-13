package se.kth.iv1350.processsale.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * This class is responsible for the log. 
 * 
 *
 */
public class LogHandler {
	private static final String FILE_NAME = "processsale_log.txt";
	private PrintWriter logger;
	
	public LogHandler() throws IOException {
		logger = new PrintWriter(new FileWriter(FILE_NAME), true);
	}

	/**
	 * Writes a log describing a thrown exception.  
	 * @param exc The exceptions that should be logged. 
	 */
	public void logException (Exception exc)
	{
		StringBuilder logFile = new StringBuilder();
		logFile.append("------------LOG---------");
		logFile.append("\n");
		logFile.append(getCurrentTime());
		logFile.append("\n");
		logFile.append("The following exception was thrown: ");
		logFile.append(exc.getMessage());
		logger.println(logFile);
        exc.printStackTrace(logger);
        logger.println("------------------------");

		
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

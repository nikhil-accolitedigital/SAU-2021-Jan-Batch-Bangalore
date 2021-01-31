package com.spring.au.LoggerAssignment;



import java.util.Scanner;

import org.apache.log4j.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LoggerAssignmentApplication {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(LoggerAssignmentApplication.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		Scanner sc = new Scanner(System.in);
        System.out.println("<----------Logger Assignment---------->");
        System.out.println("Enter the level of Logger :");
        System.out.println("         1. ALL           ");
        System.out.println("         2. DEBUG         ");
        System.out.println("         3. INFO          ");
        System.out.println("         4. WARN          ");
        System.out.println("         5. ERROR         ");
        System.out.println("         6. FATAL         ");
        System.out.println("         7. OFF           ");
        System.out.print("Enter your choice here : ");
        int ch = sc.nextInt();
		
        switch (ch) {
        case 1:
            logger.setLevel(Level.ALL);
            break;
        case 2:
            logger.setLevel(Level.DEBUG);
            break;
        case 3:
            logger.setLevel(Level.INFO);
            break;
        case 4:
            logger.setLevel(Level.WARN);
            break;
        case 5:
            logger.setLevel(Level.ERROR);
            break;
        case 6:
            logger.setLevel(Level.FATAL);
            break;
        case 7:
            logger.setLevel(Level.OFF);
            System.out.println("Turn Off logging");
            break;
    }
    logger.trace("Trace Message!");
    logger.debug("Debug Message!");
    logger.info("Info Message!");
    logger.warn("Warn Message!");
    logger.error("Error Message!");
    logger.fatal("Fatal Message!");
   

	}

}

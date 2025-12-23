package com.naresh.old.javapractice.companywise.factset;
import java.util.logging.Logger;
//1.4
public class HelloByLogger {

   /* private final static Logger logger = Logger.getLogger(HelloByLogger.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();

        logger.info("From Logger... Ola!");

    }*/
	private final static Logger LOGGER = Logger.getLogger(HelloByLogger.class.getName()); 
	public static void main(String[] args) {
		LOGGER.info("Hello");
	}
	
}
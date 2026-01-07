package com.naresh.leetcode.outputs.factset;

import java.util.logging.Level;
import java.util.logging.Logger;

// simple example using java.util.logging (no external dependency)
public class HelloByLogger {

    // use java.util.logging.Logger
    private static final Logger logger = Logger.getLogger(HelloByLogger.class.getName());

    public static void main(String[] args) {

        logger.log(Level.INFO, "From Logger... Ola!");

    }

    /*
     * Previous Log4j example:
     * import org.apache.log4j.BasicConfigurator;
     * import org.apache.log4j.Logger;
     *
     * static final Logger logger = Logger.getLogger(HelloByLogger.class);
     * BasicConfigurator.configure();
     */

}
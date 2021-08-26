package com.freesky.log4j2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://logging.apache.org/log4j/2.x/maven-artifacts.html
 * 
 * @author maxzhang
 *
 */
public class SLF4JTest {
	
	private static Logger logger = LoggerFactory.getLogger(SLF4JTest.class);

	public static void main(String[] args) {
		logger.trace("We've just greeted the user!");
		logger.debug("We've just greeted the user!");
		logger.info("We've just greeted the user!");
		logger.warn("We've just greeted the user!");
		logger.error("We've just greeted the user!");
		
		System.out.println("SLF4JTest");
	}

}

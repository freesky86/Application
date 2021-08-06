package com.freesky.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * https://www.scalyr.com/blog/maven-log4j2-project/
 * https://blog.csdn.net/u011389474/article/details/70054256
 * 
 * @author maxzhang
 *
 */
public class Log4j2Test {
	
	private static Logger logger = LogManager.getLogger(Log4j2Test.class);

	public static void main(String[] args) {
		logger.trace("We've just greeted the user!");
		logger.debug("We've just greeted the user!");
		logger.info("We've just greeted the user!");
		logger.warn("We've just greeted the user!");
		logger.error("We've just greeted the user!");
		logger.fatal("We've just greeted the user!");
		
		System.out.println("Test");
	}

}

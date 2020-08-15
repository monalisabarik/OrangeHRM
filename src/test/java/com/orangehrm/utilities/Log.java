package com.orangehrm.utilities;

import org.apache.log4j.Logger;

public class Log {
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void info(String message) {
		log.info(message);
	}
	public static void warn(String message) {
		log.warn(message);
	}
	public static void error(String message) {
		log.error(message);
	}
	public static void fatal(String message) {
		log.fatal(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}
	
	public static void startTestCase(String TestCaseName) {
		log.info("**************************"+TestCaseName+"***********************");
	}

	public static void endTestCase(){
	log.info("**************************End**********************");
	}
	
}

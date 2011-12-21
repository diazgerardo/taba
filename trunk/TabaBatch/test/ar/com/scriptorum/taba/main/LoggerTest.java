package ar.com.scriptorum.taba.main;

import org.apache.log4j.Logger;

public class LoggerTest {
	
	static Logger logger = Logger.getLogger(LoggerTest.class);
	static Logger fooLogger = Logger.getLogger("ar.com.scriptorum.taba.logger");
	public LoggerTest() {}
	
	public static void main(String [] args) {
		logger.debug("been here");
		fooLogger.debug("fooLogger - me too");
		logger.info("been here");
		fooLogger.info("fooLogger - me too");
		
	}
	

}

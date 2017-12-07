package com.auto.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	static Logger log = LogManager.getLogger(Log.class.getName());
	
	public static void beforeTestUse(){
		log.info("------------------------");
	}
	
	public static void endTestUse(){
		log.info("------------------------");
	}
	
	public static void info(String msg){
		log.info(msg);
	}
	
	public static void fatal(String msg){
		log.fatal(msg);
	}
	
	public static void error(String msg){
		log.error(msg);
	}
	
	public static void debug(String msg){
		log.debug(msg);
	}
}

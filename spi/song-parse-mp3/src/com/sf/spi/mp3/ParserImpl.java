package com.sf.spi.mp3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sf.spi.ParserManager;

public class ParserImpl extends Mp3Parser {
	
//	private static final Logger logger = LoggerFactory.getLogger(ParserImpl.class);
	
	static {
		
		try {
			ParserManager.registerParser(new ParserImpl());
//			logger.info("register parser success");
		} catch(Exception e) {
			throw new RuntimeException("can`t register parser!");
		}
		
	}
}

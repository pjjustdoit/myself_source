package com.sf.spi.mp4;

import com.sf.spi.ParserManager;

public class ParserImpl extends Mp4Parser {
	
	static {
		try {
			ParserManager.registerParser(new ParserImpl());
		} catch(Exception e) {
			throw new RuntimeException("can`t register parser!");
		}
	}
}

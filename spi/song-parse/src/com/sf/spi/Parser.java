package com.sf.spi;

public interface Parser {
	
	public Song parse(byte[] data) throws Exception;
	
}

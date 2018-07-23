package com.sf.spi.mp3;

import java.util.Arrays;

import com.sf.spi.Parser;
import com.sf.spi.Song;

public class Mp3Parser implements Parser {
	
	public final byte[] FORMAT = "MP3".getBytes();

    public final int FORMAT_LENGTH = FORMAT.length;

	@Override
	public Song parse(byte[] data) throws Exception {
		if (!isDataCompatible(data)) {
            throw new Exception("data format is wrong.");
        }
        return new Song("刘千楚", "mp3", "《北京东路的日子》");
	}
	
	
	private boolean isDataCompatible(byte[] data) {
        byte[] format = Arrays.copyOfRange(data, 0, FORMAT_LENGTH);
        return Arrays.equals(format, FORMAT);
    }

}

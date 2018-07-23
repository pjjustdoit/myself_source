package com.sf.spi.mp4;

import java.util.Arrays;

import com.sf.spi.Parser;
import com.sf.spi.Song;

public class Mp4Parser implements Parser {
	
	public final byte[] FORMAT = "MP4".getBytes();

    public final int FORMAT_LENGTH = FORMAT.length;

	@Override
	public Song parse(byte[] data) throws Exception {
		if (!isDataCompatible(data)) {
            throw new Exception("data format is wrong.");
        }
        return new Song("张学友", "mp4", "《一路上有你》");
	}
	
	
	private boolean isDataCompatible(byte[] data) {
        byte[] format = Arrays.copyOfRange(data, 0, FORMAT_LENGTH);
        return Arrays.equals(format, FORMAT);
    }

}

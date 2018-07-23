package com.sf.spi;

public class Test {
	
	public static void main(String[] args) {
		Song song = ParserManager.getSong(mockSongData("MP4"));
		System.out.println(song.getAuthor()+"/"+song.getName());
	}
	
	private static byte[] mockSongData(String data) {
		return data.getBytes();
	}
}

package com.sf.spi;

public class Song {
	
	private String author;
	private String type;
	private String name;
	private Long size;
	
	public Song(String author, String type, String name) {
		this.author = author;
		this.type = type;
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	
}

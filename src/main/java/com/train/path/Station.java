package com.train.path;

public class Station {
	private String line;
	private String name;

	public Station(String line, String name) {
		super();
		this.line = line;
		this.name = name;
	}
	
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return line + "-" + name;
	}

}

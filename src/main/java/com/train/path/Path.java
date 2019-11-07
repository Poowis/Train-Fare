package com.train.path;

import java.util.List;

public class Path {
	private List<PathInLine> path;
	
	public void add(PathInLine pathIL) {
		path.add(pathIL);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}
	@Override
	public String toString() {
		String returnString = "";
		for (int i = 0; i<path.size(); i++) {
			returnString += path.get(i)+"\n";
		}
		return returnString;
	}
	
}

package com.train.path;

import java.util.List;

public class Path {
	private List<PathSameLine> path;
	
	public void add(PathSameLine pathSL) {
		path.add(pathSL);
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

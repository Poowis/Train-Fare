package com.train.data;

import java.util.List;

import com.train.path.PathSameLine;


public interface Data {
	List<String> getLine();
	PathSameLine getPath(String start, String dest);
}

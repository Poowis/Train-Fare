package com.train.data;

import java.util.List;

import com.train.path.PathInLine;
import com.train.path.Station;


public interface Data {
	List<String> getLines();
	PathInLine getPath(Station start, Station dest);
}

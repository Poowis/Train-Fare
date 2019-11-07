package com.train.data;

import java.util.List;

import com.mongodb.*;
import com.train.path.PathInLine;
import com.train.path.Station;

public class MongoDB implements Data {
	
	private MongoClient client;
	
//	private static MongoDB instance;
//	public static MongoDB getInstance( ) {
//		if (instance == null) {
//			instance = new MongoDB();
//		}
//		return instance;
//	}
//	
	public MongoClient connect(String address, int port) {
		if (client == null) {
			client = new MongoClient(address, port);
		}
		return client;
	}
	


	@Override
	public List<String> getLines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathInLine getPath(Station start, Station dest) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		MongoClient mongoClient =  new MongoClient("localhost", 27017);
		mongoClient.getDatabaseNames().forEach(System.out::println);
		
		DB database = mongoClient.getDB("train");
		database.getCollectionNames().forEach(System.out::println);
		
		DBCollection collection = database.getCollection("bts");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("start", "prayatha");
		searchQuery.put("destination", "bangna");
		DBCursor cursor = collection.find(searchQuery);
		 
		while (cursor.hasNext()) {
		    System.out.println(cursor.next().get("start"));
		}
	}

}

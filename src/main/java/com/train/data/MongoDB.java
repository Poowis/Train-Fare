package com.train.data;

import java.util.Arrays;
import java.util.List;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import com.train.path.PathInLine;
import com.train.path.Station;

public class MongoDB implements Data {

//	private static MongoDB instance;
//	public static MongoDB getInstance( ) {
//		if (instance == null) {
//			instance = new MongoDB();
//		}
//		return instance;
//	}
//	

	private MongoClient client;

	public MongoClient connect(String address, int port) {
		if (client == null) {
			client = MongoClients
					.create(MongoClientSettings.builder()
							.applyToClusterSettings(
									builder -> builder.hosts(Arrays.asList(new ServerAddress(address, port))))
							.build());
		}
		return client;
	}
	
	private static PathInLine toPathInLine(String line, Document doc) {
		return new PathInLine(new Station(line, doc.getString("start")), new Station(line, doc.getString("destination")), doc.getDouble("fare"), doc.getString("remark"));
	}

	@Override
	public List<PathInLine> getLines(String line) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PathInLine getPath(Station start, Station dest) {
		// TODO Auto-generated method stub
		return new PathInLine(dest, dest, 0, null);
	}

	public static void main(String[] args) {
		
		String user = "app";     // the user name
		String source = "trainFare";   // the source where the user is defined
		char[] password = "NkevFQtyh9yZHZdZyW4iaBRIrp5IGF0W9Os6pyCcYw9CaZCtHY".toCharArray(); // the password as a character array
		// ...
		MongoCredential credential = MongoCredential.createCredential(user, source, password);
		
		MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
				.applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("192.168.1.222", 9000))))
				.credential(credential)
				.build());

		MongoDatabase database = mongoClient.getDatabase("trainFare");

		MongoCollection<Document> collection = database.getCollection("sdf");
		
		for (String i : database.listCollectionNames()) {
			if (i.equalsIgnoreCase("bridge")) {
				continue;
			}
			System.out.println(i);
		}
		
		for (Document i : collection.find()) {

			System.out.println(i);
		}

		
		
		
		
//		for (String i : database.listCollectionNames()) {
//			if (i.equalsIgnoreCase("bridge")) {
//				continue;
//			}
//			MongoCollection<Document> collection = database.getCollection(i);
//			FindIterable<Document> myDoc = collection.find(and(eq("start", "prayatha"), eq("destination", "bangna")));
//			System.out.print(myDoc.first());
//			System.out.println(toPathInLine(i, myDoc.first()));
//		}

//		 for (Document i: database.listCollections()) {
//			 System.out.println(i);
//		 }
//		 MongoCollection<Document> collection = database.getCollection("bts");
//		 
//		 FindIterable<Document> myDoc = collection.find(eq("start", "prayatha"));
//		 
//		 for (Document i: myDoc) {
//			 System.out.println(i);
//		 }
//		 

	}

}

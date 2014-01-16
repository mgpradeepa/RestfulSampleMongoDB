package in.mgp.rest.samples.adapter;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.MongoClient;

public class MongoConnect {
	private static final String username = "";
	private static final String password = "";

	public void createConnection() {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			// MongoClient mongoClientSecure = new MongoClient();
			// DB db = mongoClientSecure.getDB("myfirstdb");
			// boolean auth = db.authenticate(username, password.toCharArray());

			// DB db = mongo.getDB("myfirstdb");

			List<String> databaseList = mongo.getDatabaseNames();
			for (String dbs : databaseList) {
				System.out.println("Databases" + dbs);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * 
 */
package in.mgp.rest.samples.app;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * @author GPS
 * 
 */
public class AppTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB db = mongo.getDB("myfirstdb");
			DBCollection table = db.getCollection("user");

			BasicDBObject document = new BasicDBObject();
			document.put("name", "Pradeep");
			document.put("age", 26);
			document.put("create date  ", new Date());
			table.insert(document);
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "Pradeep");
			
			DBCursor cursor = table.find(searchQuery);
			
			while(cursor.hasNext()){
				System.out.println("Mongo objects" + cursor.next());
				
			}
			
		// updating
			
			BasicDBObject query = new BasicDBObject();
			query.put("name", "Pradeep");
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "Updated-Pradeep");
			
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);
			table.update(query, updateObj);
			
			
			BasicDBObject searchQuery2 
			= new BasicDBObject().append("name", "Updated-Pradeep");

		DBCursor cursor2 = table.find(searchQuery2);
		System.out.println(" number of docs in db " + table.count());

		while (cursor2.hasNext()) {
			System.out.println(cursor2.next());
		}
		
		// done
		
		System.out.println("DONe");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

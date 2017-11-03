package samples.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class MongoExample {

	public static void main(String[] args) {

		// Connect to local mongodb server
		MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
		MongoClient client = new MongoClient(uri);
		// Connect to a database named "codethen"
		MongoDatabase db = client.getDatabase("codethen");
		// Get collection called "products"
		MongoCollection<Document> products = db.getCollection("products");

		// insertExample(products);
		findExample(products);

		client.close();
	}

	private static void insertExample(MongoCollection<Document> products) {

		// From mongo shell:
		//   db.products.insert({name: "pen", price:3.0})

		Document doc = new Document();
		doc.put("name", "pen");
		doc.put("price", 3.0);
		products.insertOne(doc);
	}

	private static void findExample(MongoCollection<Document> products) {

		Bson query1 = Filters.gte("price", 300);
		Bson query2 = Filters.lt("price", 1000);
		Bson query = Filters.and(query1, query2);

		// From mongo shell:
		//   db.products.find({$and: [{price: {$gte: 300}}, {price: {$lt: 1000}}]})
		// or also:
		//   db.products.find({price: {$gte: 300, $lt: 1000}})

		MongoCursor<Document> cursor = products.find(query).iterator();

		while (cursor.hasNext()) {

			Document doc = cursor.next();
			ObjectId id = (ObjectId) doc.get("_id");
			double price = (Double) doc.get("price");
			String name = (String) doc.get("name");
			Boolean expensive = (Boolean) doc.get("expensive");

			System.out.println( name + ", " + price + ", " + expensive + " (" + id + ")");
		}

		cursor.close();
	}
}

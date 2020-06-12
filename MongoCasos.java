import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoCasos {
	//caso1: visualusar todos los datos
	public static void findAll() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost");
		DB db = mongoClient.getDB("test");
		DBCollection coll = db.getCollection("Cliente");
		DBCursor Ccursor = coll.find();
		try {
			while (Ccursor.hasNext()) {
				System.out.println(Ccursor.next());
			}
		} finally {
			Ccursor.close();
		}
	}
	
	// caso 2: buscar todos los cliente mexicanos
	public static void findBYCriteria() throws UnknownHostException {
		MongoClient m1 = new MongoClient("localhost");
		DB db = m1.getDB("test");
		DBCollection col = db.getCollection("Cliente");
		DBObject query = new BasicDBObject("Nacionalidad",
				new BasicDBObject("$eq", "Mexicano"));
		DBCursor Cursor = col.find(query);
		System.out
				.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
		try {
			while (Cursor.hasNext()) {
				System.out.println(Cursor.next());
			}
		} finally {
			Cursor.close();
		}
	}
	//caso 3: mostrar todas las empresas/personas morales
	public static void findByEquality() throws UnknownHostException {
		MongoClient m1 = new MongoClient("localhost");
		DB db = m1.getDB("test");
		DBCollection col = db.getCollection("Cliente");
		DBObject query = new BasicDBObject("Persona", "Moral");
		DBCursor c1 = col.find(query);
		System.out
				.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
		try {
			while (c1.hasNext()) {
				System.out.println(c1.next());
			}
		} finally {
			c1.close();
		}
	}
	

	//caso 4:mostrar todas la ventas de polizas
	public static void findByfields() throws UnknownHostException {
		MongoClient m1 = new MongoClient("localhost");
		DB db = m1.getDB("test");
		DBCollection col = db.getCollection("Operaciones");

		DBObject query = new BasicDBObject("Transaccion",
				new BasicDBObject("$eq", "Venta de Poliza"));
		
		BasicDBObject fields = new BasicDBObject("RFC", 1).append("Fecha", 1);
		DBCursor Cursor = col.find(query, fields);
		System.out
				.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
		try {
			while (Cursor.hasNext()) {
				System.out.println(Cursor.next());
			}
		} finally {
			Cursor.close();
		}
	}
	//caso 5 mostrar todos los cliente que no apelliden white
	public static void excludeByfields() throws UnknownHostException {
		MongoClient m1 = new MongoClient("localhost");
		DB db = m1.getDB("test");
		DBCollection col = db.getCollection("Cliente");

		DBObject query = new BasicDBObject("Apellido",
				new BasicDBObject("$eq", "White"));
		BasicDBObject fields = new BasicDBObject("mfdcountry", 0).append("cno",
				0);
		DBCursor Cursor = col.find(query, fields);
		System.out
				.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
		try {
			while (Cursor.hasNext()) {
				System.out.println(Cursor.next());
			}
		} finally {
			Cursor.close();
		}
	}



}

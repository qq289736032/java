import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by jisen on 2018/5/25.
 */
public class TestMongoDB {
    public static void main(String[] args) {
        try {
            //链接到MongoDB
            MongoClient mongoClient = new MongoClient("localhost", 27107);

            //链接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("连接到数据库成功");
            MongoCollection<Document> mycol1 = mongoDatabase.getCollection("mycol2");
            FindIterable<Document> documents = mycol1.find();
            MongoCursor<Document> iterator = documents.iterator();
            while (iterator.hasNext()){
                Document next = iterator.next();
                System.out.println(next);
            }
            System.out.println(mycol1);

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }
}

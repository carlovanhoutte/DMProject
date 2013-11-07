package tracker;

import com.mongodb.*;
import model.RFID;
import model.TrackingRecord;
import model.Zone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 7/11/13
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class DBinserter {

    public void insertIntoDB(RFID rfid, Zone zoIn, Zone zoUit, Date date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction ta = session.beginTransaction();

        TrackingRecord record = new TrackingRecord();
        record.setRfid(rfid);
        record.setZoneIn(zoIn);
        record.setZoneUit(zoUit);
        record.setTijdstip(date);

        session.saveOrUpdate(record);
        ta.commit();
    }

    public void insertIntoMongo(RFID rfid, Zone zoIn, Zone zoUit, Date date, String Artiestnaam) {

        MongoClient mongo = null;

        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        DB db = mongo.getDB("tracking");
        DBCollection collection = db.getCollection("festival");

        BasicDBObject query = new BasicDBObject("id", rfid.getId());
        DBObject result = collection.findOne(query);

        BasicDBObject trackingrecord = new BasicDBObject().append("Tijd", date).append("Zone In", zoIn).append("Zone Uit", zoUit).append("Huidige artiest", Artiestnaam);

        DBObject updated;

        if (result == null) {
            updated = new BasicDBObject("id", rfid.getId()).append("Trackingrecords", new BasicDBList().add(trackingrecord));
        } else {
            updated = new BasicDBObject("id", rfid.getId()).append("Tracknigrecords", ((BasicDBList) result.get("Trackingrecords")).add(trackingrecord));
        }
        collection.update(query, updated);
    }
}

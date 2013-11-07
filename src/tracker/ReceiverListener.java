package tracker;

import model.Optreden;
import model.RFID;
import model.Zone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import persistence.HibernateUtil;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 7/11/13
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class ReceiverListener implements MessageListener {

    DBinserter inserter;

    public ReceiverListener() {
        inserter = new DBinserter();
    }

    @Override
    public void onMessage(Message message) {
        String text = "";
        TextMessage textMessage = (TextMessage) message;
        try {
            text = textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        SAXBuilder sax = new SAXBuilder();
        Document doc = null;
        try {
            doc = sax.build(new StringReader(text));
        } catch (JDOMException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Element root = doc.getRootElement();
        Element timeE = root.getChild("timestamp");
        Element zoInE = root.getChild("zoneIn");
        Element zoUitE = root.getChild("zoneUit");
        Element rfidE = root.getChild("rfid");

        Integer id = Integer.parseInt(rfidE.getAttributeValue("id"));
        Integer zoneIn = Integer.parseInt(zoInE.getAttributeValue("zoneIn"));
        Integer zoneUit = Integer.parseInt(zoUitE.getAttributeValue("zoneUit"));
        long tijdstip = Long.parseLong(timeE.getAttributeValue("tijdstip"));

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction ta = session.beginTransaction();
        RFID rfid = (RFID) session.get(RFID.class, id);
        Zone zoIn = (Zone) session.get(Zone.class, zoneIn);
        Zone zoUit = (Zone) session.get(Zone.class, zoneUit);
        Date date = new Date(tijdstip);

        String artiest = "";

        Set<Optreden> optredens = zoIn.getOptredens();
        if (optredens != null) {
            for (Optreden optreden : optredens) {
                Date begin = optreden.getStarttijdstipOptreden();
                Date eind = optreden.getEindtijdstip();
                if (date.after(begin) && date.before(eind)) {
                    artiest = optreden.getArtiest().getNaam();
                }
            }
        }

        ta.commit();

        System.out.println(text);
        inserter.insertIntoDB(rfid, zoIn, zoUit, date);
        inserter.insertIntoMongo(rfid, zoIn, zoUit, date, artiest);
    }
}

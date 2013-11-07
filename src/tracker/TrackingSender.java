package tracker;

import org.activemq.ActiveMQConnectionFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import javax.jms.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 7/11/13
 * Time: 8:53
 * To change this template use File | Settings | File Templates.
 */
public class TrackingSender {

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Session session;
        MessageProducer producer;
        Connection connection;
        try {

            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("FESTIVAL.TRACKING");
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            Random random = new Random();
            Element root = new Element("trackingrecord");
            Element timestamp = new Element("timestamp").setAttribute("tijdstip", Calendar.getInstance().getTime().toString());
            Element id = new Element("rfid").setAttribute("id", Integer.toString(random.nextInt(250)));
            Element zoneIn = new Element("zoneIn").setAttribute("zoneIn", Integer.toString(random.nextInt(250)));
            Element zoneUit = new Element("zoneUit").setAttribute("zoneUit", Integer.toString(random.nextInt(250)));
            root.addContent(timestamp);
            root.addContent(id);
            root.addContent(zoneIn);
            root.addContent(zoneUit);
            Document document = new Document(root);
            StringWriter sw = new StringWriter();
            XMLOutputter outputter = new XMLOutputter();
            try {
                outputter.output(document, sw);
                TextMessage message = session.createTextMessage(sw.toString());
                producer.send(message);
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

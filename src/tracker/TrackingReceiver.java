package tracker;

import model.TrackingRecord;
import org.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 7/11/13
 * Time: 8:53
 * To change this template use File | Settings | File Templates.
 */
public class TrackingReceiver {

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Session session;
        MessageConsumer consumer;
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("FESTIVAL.TRACKING");
            consumer = session.createConsumer(destination);
            consumer.setMessageListener(new ReceiverListener());
            Thread.sleep(5000);
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void listen(){

    }
}


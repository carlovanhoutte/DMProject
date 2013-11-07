package tracker;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 7/11/13
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class ReceiverListener implements MessageListener {

    public ReceiverListener() {
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
        System.out.println(text);
    }
}

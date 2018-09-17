import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by jisen on 2018/9/10.
 */
public class MQListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            String text = ((TextMessage) message).getText();
            System.out.println(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

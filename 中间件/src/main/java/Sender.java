import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by jisen on 2018/9/10.
 */
public class Sender {
    private static final int SEND_NUMBER = 5;

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接实例
        Connection connection = null;
        //收发线程实例
        Session session;
        //消息发送目标地址
        Destination destination;
        // MessageProducer：消息发送者,创建者
        MessageProducer messageProducer;

        try {
            connectionFactory = new ActiveMQConnectionFactory("jisen", "jisen", "tpc://127.0.0.1:2233");
            // 获取连接实例
            connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 创建接收或发送的线程实例（创建session的时候定义是否要启用事务，且事务类型是Auto_ACKNOWLEDGE也就是消费者成功在Listern中获得消息返回时，会话自动确定用户收到消息）
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建队列（返回一个消息目的地）
            destination = session.createQueue("parryQuene");
            // 创建消息生产者
            messageProducer = session.createProducer(destination);
            // 创建TextMessage消息实体
            TextMessage message = session.createTextMessage("我是parry,这是我的第一个消息！");
            messageProducer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

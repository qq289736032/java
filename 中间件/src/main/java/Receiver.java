import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by jisen on 2018/9/10.
 */
public class Receiver {
    public static void main(String[] args) {
        // 连接工厂
        ConnectionFactory connectionFactory;
        // 连接实例
        Connection connection = null;
        // 收发的线程实例
        Session session;
        // 消息发送目标地址
        Destination destination;

        try {
            // 实例化连接工厂
            connectionFactory = new ActiveMQConnectionFactory("jisen", "jisen", "tcp://127.0.0.1:2233");
            // 获取连接实例
            connection = connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 创建接收或发送的线程实例（创建session的时候定义是否要启用事务，且事务类型是Auto_ACKNOWLEDGE也就是消费者成功在Listern中获得消息返回时，会话自动确定用户收到消息）
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // 创建队列（返回一个消息目的地）
            destination = session.createQueue("parryQuene");
            // 创建消息消费者
            MessageConsumer consumer = session.createConsumer(destination);
            //注册消息监听
            consumer.setMessageListener(new MQListener());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

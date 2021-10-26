/**
 * https://www.cnblogs.com/loong-hon/p/9661946.html
 * https://blog.csdn.net/liuyuanq123/article/details/79109218
 */
package com.freesky.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 先启动 TopicConsumer, 再启动 TopicProducer
 * 
 * @author freesky
 */
public class TopicProducer {
    public static void main(String[] args) {
        TopicProducer producer = new TopicProducer();
        try {
            producer.TestTopicProducer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestTopicProducer() throws Exception {
        // 1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        // 2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        // 3、开启连接
        connection.start();
        // 4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Topic topic = session.createTopic("test-topic");
        // 6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(topic);
        // 7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello! activeMQ: test-topic");
        // 8、发送消息
        producer.send(textMessage);
        // 9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}

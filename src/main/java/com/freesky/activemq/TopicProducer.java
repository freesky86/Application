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
 * ������ TopicConsumer, ������ TopicProducer
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
        // 1�������������Ӷ�����Ҫ�ƶ�ip�Ͷ˿ں�
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        // 2��ʹ�����ӹ�������һ�����Ӷ���
        Connection connection = connectionFactory.createConnection();
        // 3����������
        connection.start();
        // 4��ʹ�����Ӷ��󴴽��Ự��session������
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5��ʹ�ûỰ���󴴽�Ŀ����󣬰���queue��topic��һ��һ��һ�Զࣩ
        Topic topic = session.createTopic("test-topic");
        // 6��ʹ�ûỰ���󴴽������߶���
        MessageProducer producer = session.createProducer(topic);
        // 7��ʹ�ûỰ���󴴽�һ����Ϣ����
        TextMessage textMessage = session.createTextMessage("hello! activeMQ: test-topic");
        // 8��������Ϣ
        producer.send(textMessage);
        // 9���ر���Դ
        producer.close();
        session.close();
        connection.close();
    }
}

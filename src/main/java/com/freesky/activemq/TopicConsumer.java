package com.freesky.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumer {
    public static void main(String[] args) {
        TopicConsumer consumer = new TopicConsumer();
        try {
            consumer.TestTopicConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestTopicConsumer() throws Exception {
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
        MessageConsumer consumer = session.createConsumer(topic);
        // 7����consumer����������һ��messageListener��������������Ϣ
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 8������ȴ������û���Ϣ
        System.in.read();
        // 9���ر���Դ
        consumer.close();
        session.close();
        connection.close();
    }
}

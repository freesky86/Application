package com.freesky.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        Producer producer = new Producer();
        try {
            producer.testMQProducerQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testMQProducerQueue() throws Exception {
        // 1�������������Ӷ�����Ҫ�ƶ�ip�Ͷ˿ں�
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        // 2��ʹ�����ӹ�������һ�����Ӷ���
        Connection connection = connectionFactory.createConnection();
        // 3����������
        connection.start();
        // 4��ʹ�����Ӷ��󴴽��Ự��session������
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5��ʹ�ûỰ���󴴽�Ŀ����󣬰���queue��topic��һ��һ��һ�Զࣩ
        Queue queue = session.createQueue("test-queue");
        // 6��ʹ�ûỰ���󴴽������߶���
        MessageProducer producer = session.createProducer(queue);
        // 7��ʹ�ûỰ���󴴽�һ����Ϣ����
        TextMessage textMessage = session.createTextMessage("hello! activeMQ: test-queue");
        // 8��������Ϣ
        producer.send(textMessage);
        // 9���ر���Դ
        producer.close();
        session.close();
        connection.close();
    }
}

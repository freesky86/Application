/**
 * https://www.cnblogs.com/loong-hon/p/9661946.html
 * https://blog.csdn.net/liuyuanq123/article/details/79109218
 * 
 * ����activeMQ
 * D:\Software\Apache\apache-activemq-5.16.3\bin 
 * >> activemq start
 * 
 */
package com.freesky.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * MQ consumer
 * 
 * @author freesky
 */
public class Consumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        try {
            consumer.TestMQConsumerQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestMQConsumerQueue() throws Exception {
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
        MessageConsumer consumer = session.createConsumer(queue);
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

package com.freesky.pattern.listener;

/**
 * ������ģʽ�ǹ۲���ģʽ����һ����̬ https://blog.csdn.net/dongnan591172113/article/details/8771441
 * 
 * @author freesky
 */
public class TestDemo {
    public static void main(String args[]) {
        new TestDemo();
    }

    EventSource eventSource;

    public TestDemo() {
        try {
            eventSource = new EventSource();
            // �����������¼�Դ�����еǼǣ�
            DemoListener1 listener1 = new DemoListener1();
            eventSource.addDemoListener(listener1);
            eventSource.addDemoListener(new DemoListener() {
                @Override
                public void handleEvent(Event event) {
                    System.out.println("Method come from ������...");
                }
            });
            eventSource.notifyDemoEvent();// �����¼���֪ͨ������
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

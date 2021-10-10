package com.freesky.pattern.listener;

/**
 * 监听器模式是观察者模式的另一种形态 https://blog.csdn.net/dongnan591172113/article/details/8771441
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
            // 将监听器在事件源对象中登记：
            DemoListener1 listener1 = new DemoListener1();
            eventSource.addDemoListener(listener1);
            eventSource.addDemoListener(new DemoListener() {
                @Override
                public void handleEvent(Event event) {
                    System.out.println("Method come from 匿名类...");
                }
            });
            eventSource.notifyDemoEvent();// 触发事件、通知监听器
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

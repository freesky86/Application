package com.freesky.pattern.listener;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 事件源
 * 
 * @author freesky
 */
public class EventSource {
    private Vector<DemoListener> repository = new Vector<>();// 监听自己的监听器队列

    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }

    public void notifyDemoEvent() {// 通知所有的监听器
        Enumeration<DemoListener> enums = repository.elements();
        while (enums.hasMoreElements()) {
            DemoListener dl = enums.nextElement();
            dl.handleEvent(new Event(this));
        }
    }
}

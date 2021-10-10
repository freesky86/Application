package com.freesky.pattern.listener;

import java.util.Enumeration;
import java.util.Vector;

/**
 * �¼�Դ
 * 
 * @author freesky
 */
public class EventSource {
    private Vector<DemoListener> repository = new Vector<>();// �����Լ��ļ���������

    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }

    public void notifyDemoEvent() {// ֪ͨ���еļ�����
        Enumeration<DemoListener> enums = repository.elements();
        while (enums.hasMoreElements()) {
            DemoListener dl = enums.nextElement();
            dl.handleEvent(new Event(this));
        }
    }
}

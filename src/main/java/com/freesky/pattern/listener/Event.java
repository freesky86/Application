package com.freesky.pattern.listener;

import java.util.EventObject;

public class Event extends EventObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Event(Object source) {
        super(source);// source���¼�Դ�������ڽ����Ϸ����ĵ����ť�¼��еİ�ť
        // ���� Event �ڹ���ʱ�������˶��� "source"�����߼�����Ϊ�ö�������������й� Event �Ķ���
    }

    public void say() {
        System.out.println("This is say method...");
    }
}

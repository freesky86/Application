package com.freesky.pattern.listener;

public interface DemoListener extends java.util.EventListener {
    // EventListener�������¼��������ӿڱ�����չ�ı�ǽӿڡ���Ϊ���������ݵı�ǽӿڡ�
    // �����¼��������������Լ��������£�
    public void handleEvent(Event dm);
}

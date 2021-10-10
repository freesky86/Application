package com.freesky.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲��ߣ�Ҳ�Ƕ�����
 * 
 * @author freesky
 */
class MyObserver implements Observer {
    private int value;

    @Override
    public void update(Observable o, Object arg) {
        value = ((Subject) o).getValue();
        System.out.println("#" + value);
    }
}

/**
 * �۲���ģʽ(����-����ģʽ) https://www.cnblogs.com/learnhow/p/5959561.html
 * 
 * @author freesky
 */
public class Progress {
    public static void main(String[] args) {
        MyObserver observer = new MyObserver();
        Subject subject = new Subject(); // һ����������ж��������
        subject.addObserver(observer);

        MyObserver observer2 = new MyObserver();
        subject.addObserver(observer2);

        subject.onStart();
    }
}

/**
 * ���⣬Ҳ�Ǳ��۲���
 * 
 * @author freesky
 */
class Subject extends Observable {
    private int value;

    public int getValue() {
        return value;
    }

    public void onStart() {
        progress();
    }

    /*
     * ���ⷢ��
     */
    private void progress() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = i;
            setChanged(); // ֵ�����ı�
            notifyObservers(); // ��������ע��Ĺ۲���
        }
    }
}

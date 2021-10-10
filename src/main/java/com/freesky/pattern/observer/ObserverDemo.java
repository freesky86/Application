package com.freesky.pattern.observer;

class BeingWatched extends java.util.Observable {
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupeted");
            }
        }
    }
}

/**
 * �۲���ģʽ �ֳ�Ϊ���ġ�����ģʽ https://blog.csdn.net/dongnan591172113/article/details/8771441
 * 
 * @author freesky
 */
public class ObserverDemo {
    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();// �ܲ���
        Watcher watcher = new Watcher();// �۲���
        beingWatched.addObserver(watcher);
        Watcher watcher2 = new Watcher();
        beingWatched.addObserver(watcher2);
        beingWatched.counter(10);
    }
}

class Watcher implements java.util.Observer {
    @Override
    public void update(java.util.Observable obj, Object arg) {
        System.out.println("Update() called, count is " + ((Integer) arg).intValue());
    }
};
package com.freesky.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者，也是订阅者
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
 * 观察者模式(发布-订阅模式) https://www.cnblogs.com/learnhow/p/5959561.html
 * 
 * @author freesky
 */
public class Progress {
    public static void main(String[] args) {
        MyObserver observer = new MyObserver();
        Subject subject = new Subject(); // 一个主题可以有多个订阅者
        subject.addObserver(observer);

        MyObserver observer2 = new MyObserver();
        subject.addObserver(observer2);

        subject.onStart();
    }
}

/**
 * 主题，也是被观察者
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
     * 主题发布
     */
    private void progress() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = i;
            setChanged(); // 值发生改变
            notifyObservers(); // 调用所有注册的观察者
        }
    }
}

package com.freesky.pattern.listener;

public class DemoListener1 implements DemoListener {
    @Override
    public void handleEvent(Event event) {
        System.out.println("Inside listener1...");
        System.out.println(event.getSource().getClass());
        event.say();// »Øµ÷
    }
}

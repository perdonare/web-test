package com.lance.test.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by perdonare on 2015/12/19.
 */
public class TestEvent extends ApplicationEvent {
    private final String address;
    public TestEvent(Object source,String address) {
        super(source);
        this.address=address;
    }

    public void shown() {
        System.out.println(address);
    }
}

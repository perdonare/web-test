package com.lance.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by perdonare on 2017/1/18.
 */
public class LanceEvent extends ApplicationEvent {
    private String name;
    private int age;
    public LanceEvent(Object source,String name,int age) {
        super(source);
        this.name = name;
        this.age = age;
    }

    public String getAll() {
        return age + name;
    }
}

package com.lance.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2017/1/18.
 */
@Service
public class LancePublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void show(String name,int age) {
        if (name.equals("lance")) {
            LanceEvent lanceEvent = new LanceEvent(this, name, age);
            applicationEventPublisher.publishEvent(lanceEvent);
        }
    }

}

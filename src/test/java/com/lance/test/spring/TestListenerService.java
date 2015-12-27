package com.lance.test.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by perdonare on 2015/12/19.
 */
@Service
public class TestListenerService {
    @Resource
    private ApplicationEventPublisher publisher;


    public void sendEmail(String address) {
        if (address.equals("mail")) {
            TestEvent testEvent = new TestEvent(this,address);
            publisher.publishEvent(testEvent);
        }
    }
}

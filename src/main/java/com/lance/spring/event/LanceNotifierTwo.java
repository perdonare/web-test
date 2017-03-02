package com.lance.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2017/1/18.
 */
@Service
public class LanceNotifierTwo {
    @EventListener
    @Async
    public void onApplicationEvent(LanceEvent lanceEvent) {
        System.out.println("event2");
        System.out.println(lanceEvent.getAll());
    }
}

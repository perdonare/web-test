package com.lance.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2017/1/18.
 */
@Service
public class LanceNotifier  {
    @EventListener
    @Async
    public void eventSet(LanceEvent lanceEvent) {
        System.out.println("event");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(lanceEvent.getAll());
    }

   /* @Override
    public void onApplicationEvent(LanceEvent lanceEvent) {
        System.out.println("event");
        System.out.println(lanceEvent.getAll());
    }*/
}

package com.lance.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by perdonare on 2017/1/18.
 */
//@Service
public class LanceMulticast implements ApplicationEventMulticaster {
    List<ApplicationListener<LanceEvent>> listeners = new ArrayList<>();

    @Override
    public void addApplicationListener(ApplicationListener applicationListener) {
        listeners.add(applicationListener);
    }

    @Override
    public void addApplicationListenerBean(String s) {

    }

    @Override
    public void removeApplicationListener(ApplicationListener applicationListener) {
        listeners.remove(applicationListener);
    }

    @Override
    public void removeApplicationListenerBean(String s) {

    }

    @Override
    public void removeAllListeners() {
        listeners.clear();
    }

    @Override
    public void multicastEvent(ApplicationEvent applicationEvent) {
        listeners.forEach(item->{
            item.onApplicationEvent((LanceEvent) applicationEvent);
        });
    }


    @Override
    public void multicastEvent(ApplicationEvent applicationEvent, ResolvableType resolvableType) {
        listeners.forEach(item->{
            item.onApplicationEvent((LanceEvent) applicationEvent);
        });
    }
}

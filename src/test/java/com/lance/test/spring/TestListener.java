package com.lance.test.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/19.
 */
@Service
public class TestListener implements ApplicationListener<TestEvent>{
    @Override
    public void onApplicationEvent(TestEvent event) {
        event.shown();
    }
}

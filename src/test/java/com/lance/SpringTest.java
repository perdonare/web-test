package com.lance;

import com.lance.spring.event.LancePublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by perdonare on 2017/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SpringTest {
    @Autowired
    private LancePublisher lancePublisher;

    @Test
    public void testEvent() throws InterruptedException {
        lancePublisher.show("lance",28);
        lancePublisher.show("aaa",28);
        Thread.sleep(1000000l);
    }
}

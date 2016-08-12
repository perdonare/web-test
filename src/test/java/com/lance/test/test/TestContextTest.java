package com.lance.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by perdonare on 2016/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TestContextTest {

    //可以直接注入
    @Autowired
    private ApplicationContext  applicationContext;

    @Test
    public void testContext() {
        MockDemo mockDemo = applicationContext.getBean(MockDemo.class);
        System.out.println(mockDemo);
    }
}

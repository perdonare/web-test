package com.lance.test.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by perdonare on 2016/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class EnvironmentTest {
    @Autowired
    private MockDemo mockDemo;




    @Test
    public void testMockEnvironment() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("name","lance");
        System.out.println(mockEnvironment.getProperty("name"));
    }

}

package com.lance.test.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2016/7/6.
 */
@Service
public class MockDemo {
    private Environment environment;


    public String helloMock() {
        return environment.getProperty("name");
    }
}

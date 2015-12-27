package com.lance.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/17.
 */
@Service
public class TestModelOneOne {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private Environment environment;

    public void contextFun() {
        System.out.println(context.getStartupDate());
        System.out.println(environment.getProperty("JAVA_HOME"));
    }
}

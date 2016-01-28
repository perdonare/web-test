package com.lance.test.spring;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.reflect.Method;

/**
 * Created by perdonare on 2015/12/13.
 */
@Service
public class TestModelSeven {

    @PostConstruct
    public void construct() {
        System.out.println("construct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

}

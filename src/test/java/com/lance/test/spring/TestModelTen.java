package com.lance.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/17.
 */
@Service
public class TestModelTen {
    private TestModelOne testModelOne;

    @Autowired
    public TestModelTen( TestModelOne testModelOne){
        System.out.println(testModelOne);
    }
}

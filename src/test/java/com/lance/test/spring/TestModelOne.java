package com.lance.test.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/13.
 */
@Service
public class TestModelOne {
    @Value("lance")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.lance.test.test;

import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2016/7/6.
 */

@Service
public class ReflectionTestUtilsDemo {
    private String name;
    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

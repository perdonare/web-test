package com.lance.test.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/20.
 */
@Service
public class TestSpelModel {
    @Value("#{testModelOne.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.lance.test.core.serial;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by perdonare on 2016/4/4.
 */

public class Model implements Serializable {
    private static final long serialVersionUID = 5728719487281615282L;
    private String name;

    private int age;

    private  String test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    private void readObjectNoData() {
        this.test="test";
    }

}

package com.lance.test.spring;

/**
 * Created by perdonare on 2015/12/13.
 */
public class TestModelTwo {
    private String name;
    private TestModelOne modelOne;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestModelOne getModelOne() {
        return modelOne;
    }

    public void setModelOne(TestModelOne modelOne) {
        this.modelOne = modelOne;
    }
}

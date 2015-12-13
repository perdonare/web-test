package com.lance.test.spring;

/**
 * Created by perdonare on 2015/12/13.
 */
public abstract class TestModelFour {
    private String name;

    private TestModelThree testModelThree;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestModelThree getTestModelThree() {
        return getThree();
    }

    public void setTestModelThree(TestModelThree testModelThree) {
        this.testModelThree = testModelThree;
    }

    public abstract TestModelThree getThree();
}

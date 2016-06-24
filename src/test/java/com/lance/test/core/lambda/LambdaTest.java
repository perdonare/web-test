package com.lance.test.core.lambda;

import org.junit.Test;

import java.lang.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by perdonare on 2016/6/14.
 */
public class LambdaTest {
    @Test
    public void testHelloWorld() {
        Arrays.asList("a","b","c","d").forEach(e-> System.out.println(e));
    }

    @Test
    public void testHelloWorld2() {
        Arrays.asList("a","b","c","d").forEach(e-> {
            System.out.println(e);
            System.out.println(new Date());
        });
    }

    @Test
    public void testReturn() {
        Arrays.asList("a","b","c").sort((e1,e2)->{
            return e1.compareTo(e2);
        });
    }

    @Test
    public void testFunctionalInterface() {
        fun((e)-> System.out.println(e+e));

    }

    public void fun(FunctionalInterface functionalInterface) {
        System.out.println("begin");
        functionalInterface.function(1);
        System.out.println("end");
    }
}

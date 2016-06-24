package com.lance.test.core.reflect;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by perdonare on 2016/6/16.
 */
public class ReflectNewTest {
    @Test
    public void testReflect() throws Exception {


    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectNewTest.class.getMethod("forTest",String.class);
        for (Parameter parameter:method.getParameters()) {
            System.out.println(parameter.getName());
        }

    }

    public void forTest(String name) {
        System.out.println(name);
    }
}

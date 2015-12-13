package com.lance.test.spring;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by perdonare on 2015/12/13.
 */
public class TestModelSix implements MethodReplacer{


    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        //method.invoke(obj,args);   todo
        return args[0]+"==============";
    }
}

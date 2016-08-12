package com.lance.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Created by perdonare on 2016/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ReflectionTestUtilsTest {
    @Autowired
    private ReflectionTestUtilsDemo reflectionTestUtilsDemo;


    @Test
    public void testReflectionTestUtils() {
        //可以设置私有函数的参数值
        ReflectionTestUtils.invokeMethod(reflectionTestUtilsDemo,"setName","lance");
        System.out.println(reflectionTestUtilsDemo.getName());
    }

}

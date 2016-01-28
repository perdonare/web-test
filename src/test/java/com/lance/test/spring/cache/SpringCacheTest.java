package com.lance.test.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by perdonare on 2015/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class SpringCacheTest {
    @Autowired
    private CacheTestObject cacheTestObject;

    @Test
    public void testCache() throws InterruptedException {
        System.out.println("==========="+cacheTestObject.getMoney());
        Thread.sleep(632);

        System.out.println("==========="+cacheTestObject.getMoney());

        Thread.sleep(1232);
        System.out.println("==========="+cacheTestObject.getAnotherMoney());
        Thread.sleep(1221);
        System.out.println("==========="+cacheTestObject.getMoney());

    }

    @Test
    public void testCachePut() throws InterruptedException {
        System.out.println("");
        System.out.println("==========="+cacheTestObject.getOne());
        Thread.sleep(632);
        System.out.println("==========="+cacheTestObject.getOne());

    }

    @Test
    public void testCacheAll() throws InterruptedException {
        System.out.println("");
        System.out.println("==========="+cacheTestObject.getMoney());
        Thread.sleep(431);

        System.out.println("==========="+cacheTestObject.getAll());

        Thread.sleep(632);
        System.out.println("==========="+cacheTestObject.getMoney());
        Thread.sleep(976);
        System.out.println("==========="+cacheTestObject.getAll());
    }
}

package com.lance.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by perdonare on 2015/12/15.
 */
public class FinalTest {
    private long start;

    @Before
    public void beforeTest() {
        start = System.currentTimeMillis();
    }

    @After
    public void afterTest() {
        long end = System.currentTimeMillis() - start;
        System.out.println("time :" + end/1000);
    }


    @Test
    public void testFinal () {
        int a = 0;
        while (a<10000) {
            long b = fun();
            System.out.println(b);
            a++;
        }
    }

    public final long fun() {
        long a = 1000*1000*1000;
        a++;
        return  a*a;

    }
}

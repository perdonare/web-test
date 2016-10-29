package com.lance.rxjava;

import com.lance.reactive.RxJavaDemo;
import org.junit.Test;

/**
 * Created by perdonare on 2016/10/27.
 */
public class RxJavaTest {
    @Test
    public void testHelloWorld() {
        RxJavaDemo.hello("lance","liang");
        RxJavaDemo.helloFromExists("lance","liang");
        RxJavaDemo.helloCreate("lance");
        RxJavaDemo.helloAsyCreate("lance");
        RxJavaDemo.helloMap("lance1","lance2","lance3");
        RxJavaDemo.helloFlatMap("lance1","lance2","lance3");

    }
}

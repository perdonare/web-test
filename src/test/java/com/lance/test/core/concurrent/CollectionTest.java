package com.lance.test.core.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;

/**
 * Created by perdonare on 2016/3/30.
 */
public class CollectionTest {
    @Test
    public void testDequeue() throws InterruptedException {
        Collection collection = new ArrayList<>();
        collection.add(new Object());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            if (collection.size()>0);        }
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {

            if(collection.isEmpty());
        }
        end = System.currentTimeMillis() - start;
        System.out.println(end);
    }
}

package com.lance.test.core.concurrent;

import org.junit.Test;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;

/**
 * Created by perdonare on 2016/3/30.
 */
public class DequeueTest {
    @Test
    public void testDequeue() throws InterruptedException {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>();

        Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }).submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        System.out.println("put "+ "aaaa"+i);
                        blockingDeque.putFirst("aaaa"+i);
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }).submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        System.out.println("poll  "+blockingDeque.takeLast());
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread.sleep(5000000);
    }
}

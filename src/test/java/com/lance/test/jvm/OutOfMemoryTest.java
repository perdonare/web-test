package com.lance.test.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by perdonare on 2016/5/21.
 */
public class OutOfMemoryTest {

    @Test
    public void testDumpMemory() {
        List list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }
}

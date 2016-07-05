package com.lance.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by perdonare on 2016/5/21.
 */
public class JvmTest {
    /**
     -Xms20m
     -Xmx20m
     -Xmn10m
     -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        while (true) {
            List list = new ArrayList<>();
            while (true) {
                list.add(new JvmTest());
            }
        }
    }
}

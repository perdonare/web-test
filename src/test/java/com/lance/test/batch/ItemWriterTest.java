package com.lance.test.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by perdonare on 2016/4/15.
 */
@Service
public class ItemWriterTest implements ItemWriter {
    @Override
    public void write(List list) throws Exception {
        System.out.println("write");
    }
}

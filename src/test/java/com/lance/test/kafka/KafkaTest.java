package com.lance.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by perdonare on 2015/12/23.
 */
public class KafkaTest {
    private KafkaProducer<String,String> producer;
    private KafkaConsumer<String,String> consumer;
    @Before
    public void init() throws IOException {
        //默认使用类的包下的路径作为路径 所以要加 /
        //InputStream inputStream = KafkaTest.class.getResourceAsStream("/kafka.properties");
        //默认从classPath根下取  不能加 /
        InputStream inputStream = KafkaTest.class.getClassLoader().getResourceAsStream("kafka.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        //producer
        producer = new KafkaProducer(properties);

        properties.load(inputStream);
        //consumer
        consumer = new KafkaConsumer<>(properties);
    }
    @Test
    public void testProducer() {
        ProducerRecord<String,String> record = new ProducerRecord<>("test","name","lance");
        producer.send(record);
    }

    @Test
    public void testConsumer() {
        consumer.subscribe(Arrays.asList("test"));
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        int commitInterval = 1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            if (!records.isEmpty()) {
                Iterator<ConsumerRecord<String,String>> iterator = records.iterator();
                while (iterator.hasNext()) {
                    ConsumerRecord<String,String> record = iterator.next();
                    buffer.add(record);
                    if (buffer.size() >= commitInterval) {
                        show(buffer);
                        consumer.commitSync();
                        buffer.clear();
                    }
                }
            }
        }
    }

    private void show(List<ConsumerRecord<String, String>> buffer) {
        for (ConsumerRecord<String,String> consumerRecord : buffer) {
            System.out.println("===="+consumerRecord.toString());
        }
    }
}

package com.lance.test.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by perdonare on 2015/12/27.
 */
public class KafkaTest {
    private static final String PRODUCER_PATH="com/lance/kafka/kafka-producer.properties";
    private static final String CONSUMER_PATH="com/lance/kafka/kafka-consumer.properties";
    private Producer<String,String> producer;
    //private Consumer<String,String> consumer;
    @Before
    public void createProducerAndConsumer() throws IOException {

        //create producer
        InputStream inputStream = KafkaTest.class.getClassLoader().getResourceAsStream(PRODUCER_PATH);
        Properties properties = new Properties();
        properties.load(inputStream);
        Producer<String,String> producer = new KafkaProducer<String,String>(properties);
        this.producer = producer;

        //create consumer
        inputStream = KafkaTest.class.getClassLoader().getResourceAsStream(CONSUMER_PATH);
        properties.load(inputStream);
        Consumer<String,String> consumer = new KafkaConsumer<String, String>(properties);
        //this.consumer = consumer;
    }

    @Test
    public void testProducer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer(props);
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                    "test", Integer.toString(i), Integer.toString(i));
            System.out.println("============="+producerRecord);
            producer.send(producerRecord);
        }

        producer.close();



/*
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>("test","message","helloworld");
        for (int i = 0; i < 100000; i++) {
            producer.send(producerRecord);
            System.out.println("send =====================");
        }

        producer.close();*/
    }

    @Test
    public void testConsumer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(
                props);
        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("===============offset = %d, key = %s, value = %s \n",
                        record.offset(), record.key(), record.value());
        }
    }
}

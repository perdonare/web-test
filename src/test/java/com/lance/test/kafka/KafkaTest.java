package com.lance.test.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
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
    //@Before
    public void init() throws IOException {
        //默认使用类的包下的路径作为路径 所以要加 /
        //InputStream inputStream = KafkaTest.class.getResourceAsStream("/kafka.properties");
        //默认从classPath根下取  不能加 /


        //consumer

    }
    @Test
    public void testProducer() throws IOException, InterruptedException {
        InputStream inputStream = KafkaTest.class.getClassLoader().getResourceAsStream("com/lance/kafka/kafka-producer.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        //producer
        producer = new KafkaProducer(properties);

        for(int i=0;i<100;i++) {
            ProducerRecord<String,String> record;
            if (i%2==0) {
                record = new ProducerRecord<>("test",1,"name",i+"");
            } else {
                record = new ProducerRecord<>("test",0,"name",i+"");
            }
            System.out.println(record);
            producer.send(record);

        }
        producer.close();
        //Thread.sleep(10000);
    }

    @Test
    public void testConsumer() throws IOException {
        InputStream inputStream = KafkaTest.class.getClassLoader().getResourceAsStream("com/lance/kafka/kafka-consumer.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("test"));
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        int commitInterval = 1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(10);
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














    @Test
    public void testConsumerPartition() throws IOException {
        InputStream inputStream = KafkaTest.class.getClassLoader().getResourceAsStream("com/lance/kafka/kafka-consumer.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        consumer = new KafkaConsumer<>(properties);
        TopicPartition topicPartition = new TopicPartition("test",0);
        List<TopicPartition> topicPartitions = new ArrayList<>();
        topicPartitions.add(topicPartition);
        consumer.assign(topicPartitions);
        //consumer.subscribe(Arrays.asList("test"));

        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        int commitInterval = 1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(10);
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

    @Test
    public void testConsumerPartition2() throws IOException {
        InputStream inputStream = KafkaTest.class.getClassLoader().getResourceAsStream("com/lance/kafka/kafka-consumer.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        consumer = new KafkaConsumer<>(properties);
        //consumer.subscribe(Arrays.asList("test"));
        TopicPartition topicPartition = new TopicPartition("test",1);
        List<TopicPartition> topicPartitions = new ArrayList<>();
        topicPartitions.add(topicPartition);
        consumer.assign(topicPartitions);
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        int commitInterval = 1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(10);
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
            System.out.println("==============="+consumerRecord.toString());
        }
    }

    @Test
    public void testP() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer(props);
        for(int i = 1; i < 10; i++)
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)));
        producer.close();
    }
}

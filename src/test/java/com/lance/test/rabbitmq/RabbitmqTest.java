package com.lance.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by perdonare on 2016/2/4.
 */
public class RabbitmqTest {
    private final static String QUEUE_NAME = "hello";

    /**
     * 1. rabbitmqctl add_user test test
     * 2.  rabbitmqctl set_user_tags test  administrator
     * 3. rabbitmqctl  set_permissions -p /  test '.*' '.*' '.*'
     * @throws IOException
     * @throws TimeoutException
     */
    @Test
    public void testProducer() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.174.128");
        factory.setUsername("test");
        factory.setPassword("test");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println("  Sent: '" + message + "'");
        channel.close();
        connection.close();
    }

    @Test
    public void testConsumer() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.174.128");
        factory.setUsername("test");
        factory.setPassword("test");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" Received:'" + message + "'");
        }
    }
}

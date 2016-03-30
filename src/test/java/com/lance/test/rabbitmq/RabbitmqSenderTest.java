package com.lance.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by perdonare on 2016/3/26.
 */
public class RabbitmqSenderTest {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    public static final String HOST = "localhost";


    public static final String VHOST = "/test";
    public static final String QUEUE_NAME = "/test_queue";
    public static final String USERNAME = "test";
    public static final String PASSWORD = "test";

    @Test
    public void testBasicSender() throws IOException, TimeoutException, InterruptedException {
        connectionFactory.setHost(HOST);
        connectionFactory.setVirtualHost(VHOST);
        connectionFactory.setUsername(USERNAME);
        connectionFactory.setPassword(PASSWORD);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        /**
         * @param queue 队列名称
         * @param durable true if we are declaring a durable queue (the queue will survive a server restart)
         * @param exclusive (一个生产者对应一个消费者)
         * @param autoDelete 当最后一个消费者取消订阅的时候队列会自动移除
         * @param arguments 其他属性
         * @return 创建成功的声明
         */
        //channel.queueDeclare(QUEUE_NAME,false,true,false,null);

        String message = "hello world two";


        /**
         * @param exchange 交换器
         * @param routingKey 路由键
         * @param mandatory true if the 'mandatory' flag is to be set
         * @param immediate true if the 'immediate' flag is to be
         * set. Note that the RabbitMQ server does not support this flag.
         * @param props other properties for the message - routing headers etc
         * @param body 消息体
         * @throws java.io.IOException if an error is encountered
         */
        //channel.basicPublish("test_exchanger","test_routingKey",false,null,message.getBytes());

        for (int i = 0; i < 100000; i++) {
            channel.basicPublish("test_exchanger_two","test_routing_key_one",false,null,(message+i).getBytes());
            Thread.sleep(5000);
        }
        channel.close();
    }

}

package com.lance.test.rabbitmq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by perdonare on 2016/3/26.
 */
public class RabbitRecevicerTest {
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public static final String HOST = "localhost";
    public static final String VHOST = "/test";
    public static final String QUEUE_NAME = "test_queue_one";
    public static final String USERNAME = "test";
    public static final String PASSWORD = "test";

    @Test
    public void testBasicConsume() throws IOException, TimeoutException, InterruptedException {
        connectionFactory.setHost(HOST);
        connectionFactory.setVirtualHost(VHOST);
        connectionFactory.setUsername(USERNAME);
        connectionFactory.setPassword(PASSWORD);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //为了保证队列存在，如果直接使用的话可能启动的时候生产者还未创建队列导致错误
        //channel.queueDeclare(QUEUE_NAME,false,true,false,null);
        Consumer consumer = new Consumer() {
            @Override
            //消费的时候只有第一次连接上才会调用此方法
            public void handleConsumeOk(String consumerTag) {
                System.out.println("handleConsumeOk    "+consumerTag);
            }

            @Override
            public void handleCancelOk(String consumerTag) {

            }

            @Override
            public void handleCancel(String consumerTag) throws IOException {

            }

            @Override
            public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

            }

            @Override
            public void handleRecoverOk(String consumerTag) {

            }
            //消费的时候每次都会调用此方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("handleDelivery        "+new String(body));

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        // 由于 auto-delete的设置 注意 当最后一个消费者取消订阅的时候会删除队列
            channel.basicConsume(QUEUE_NAME,true,consumer);
            Thread.sleep(300000);

    }
}

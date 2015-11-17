package com.lance.test.netty;

import org.junit.Test;

/**
 * Created by perdonare on 2015/10/31.
 */
public class NettyTest {
    @Test
    public void testServer() throws Exception{
        int  port = 8086;
        new DiscardServer(port).run();
    }

    @Test
    public void testClient() throws Exception{
        int port = 8086;
        new TimerClient().connect("127.0.0.1",port);
        Thread.sleep(5000);
    }
}

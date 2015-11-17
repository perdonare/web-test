package com.lance.test.netty.websocket;

import org.junit.Test;

/**
 * Created by perdonare on 2015/11/15.
 */
public class WebSocketTest {

    @Test
    public void testWebSocket(){
        WebSocketServer webSocketServer = new WebSocketServer(8080);
        webSocketServer.run();
    }
}

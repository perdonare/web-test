package com.lance.test.core.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by perdonare on 2017/3/13.
 */
public class SelectorTest {

    @Test
    public void testSelect() throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE);


        while (true) {
            int readyChannel = selector.select();
            if (readyChannel == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    System.out.println("accept");
                } else if (selectionKey.isConnectable()) {
                    System.out.println("connect");
                } else if (selectionKey.isReadable()) {
                    //读取数据
                    ServerSocketChannel socketChannel = (ServerSocketChannel) selectionKey.channel();
                    //socketChannel
                } else if (selectionKey.isWritable()) {

                }
                iterator.remove();
            }

        }

    }
}

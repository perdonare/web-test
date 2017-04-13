package com.lance.test.core.nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by perd«onare on 2017/3/10.
 */
public class NIOTest {
    @Test
    public void first() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/test/nio/local.snapshot", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int count = fileChannel.read(byteBuffer);
        while (count != -1) {
            //System.out.println("read " + count);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }
            byteBuffer.clear();
            count = fileChannel.read(byteBuffer);
        }
    }


    @Test
    public void second() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/test/nio/local.snapshot", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int count = fileChannel.read(byteBuffer);
        while (count != -1) {
            //System.out.println("read " + count);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }

            byteBuffer.rewind();//回到初始位置重新读取
            while (byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }

            byteBuffer.clear();
            count = fileChannel.read(byteBuffer);
        }
    }


    @Test
    public void third() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/test/nio/local.snapshot", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int count = fileChannel.read(byteBuffer);
        while (count != -1) {
            //System.out.println("read " + count);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                Buffer buffer = null;
                if ((int) byteBuffer.get() == 1) {
                    buffer =  byteBuffer.mark();
                }
                System.out.print((char)byteBuffer.get());
                if (buffer != null) {
                    buffer.reset();
                }
            }



            byteBuffer.clear();
            count = fileChannel.read(byteBuffer);
        }
    }

    @Test
    public void fourth() throws Exception{
        RandomAccessFile file1 = new RandomAccessFile("/test/nio/first.txt", "rw");
        RandomAccessFile file2 = new RandomAccessFile("/test/nio/second.txt", "rw");

        FileChannel channel1 = file1.getChannel();
        FileChannel channel2 = file2.getChannel();

        channel2.transferFrom(channel1, 0, channel2.size());



        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int count = channel2.read(byteBuffer);
        while (count != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            count = channel2.read(byteBuffer);
        }
        channel1.close();
        channel2.close();
        file2.close();
        file1.close();
    }
}

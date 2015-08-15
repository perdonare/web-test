package com.lance.test.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by perdonare on 2015/6/6.
 */
public class NioFileCreateTest {
    @Test
    public void testSlice(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0 ; i < byteBuffer.capacity() ;++i) {
            byteBuffer.put( (byte) i);
        }
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        while (byteBuffer.remaining()>0){
            System.out.println(byteBuffer.get());
        }

        System.out.println("================");


        byteBuffer.position(2);
        byteBuffer.limit(5);

        ByteBuffer buffer = byteBuffer.slice();
        for (int i = 0 ; i < buffer.capacity() ; ++i) {
            byte b = buffer.get(i);
            b *= 11;
            buffer.put(i, b);
        }

        while (buffer.remaining()>0){
            System.out.println(buffer.get());
        }

        System.out.println("================");


        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        while (byteBuffer.remaining()>0){
            System.out.println(byteBuffer.get());
        }


    }

    @Test
    public void testFileChannel() throws IOException {
        FileChannel fc = null;
        MappedByteBuffer mbb = fc.map( FileChannel.MapMode.READ_WRITE,
                0, 1024 );
    }
}

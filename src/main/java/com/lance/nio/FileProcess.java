/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      FileProcess.java
 * Create on:      2015/8/6 0006 18:10
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/8/6 0006 18:10               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.nio;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <b>DESCRIPTION:</b><br/>
 * <b>Create on:</b>2015/8/6 0006<br/>
 *
 * @author 袁其亮
 */
public class FileProcess {
    @Test
    public void testFileRead() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("f:/test.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(fileChannel.read(byteBuffer)!=-1){
            System.out.println(byteBuffer.asCharBuffer());
        }

    }

    @Test
    public void testFileInOut() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(new File("f:/win64_11gR2_database_1of2.zip"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("f:/win64_11gR2_database_1of22.zip"));
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(true) {
            byteBuffer.clear();
            int r = channel.read(byteBuffer);
            if (r == -1) {
                break;
            }
            byteBuffer.flip();
            fileOutputStream.write(byteBuffer.array());
        }

        long finish = System.currentTimeMillis() - start;
        System.out.println("花费时间: "  + finish/1000);
    }

    @Test//测试结果 NIO比IO有3.5倍的性能提升
    public void testIOInOut() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(new File("f:/win64_11gR2_database_1of2.zip"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("f:/win64_11gR2_database_1of22.zip"));
        byte[] bytes = new byte[1024];
        int b = 0;
        while((b = fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,b);
        }
        long finish = System.currentTimeMillis() - start;
        System.out.println("花费时间: "  + finish/1000);
    }
}

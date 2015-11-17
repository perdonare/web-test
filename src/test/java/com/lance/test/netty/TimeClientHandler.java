package com.lance.test.netty;

import com.lance.test.netty.protobuf.GoodsReq;
import com.lance.test.netty.protobuf.GoodsResp;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by perdonare on 2015/11/1.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private int count;
    private byte[] req;

    public TimeClientHandler() {
        req = ("query client time order"+"##").getBytes();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        GoodsReq.GoodsRequest.Builder builder = GoodsReq.GoodsRequest.newBuilder();
        GoodsReq.GoodsRequest request = builder.setId(1)
                .setName("lance")
                .setNum(1000)
                .setRequestCode("respionseaaaa")
                .build();
        ctx.writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        GoodsResp.GoodsResponse response = (GoodsResp.GoodsResponse) msg;
        System.out.println(response.getResponseCode());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}

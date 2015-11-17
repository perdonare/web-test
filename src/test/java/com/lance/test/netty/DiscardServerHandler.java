package com.lance.test.netty;

import com.lance.test.netty.protobuf.GoodsReq;
import com.lance.test.netty.protobuf.GoodsResp;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by perdonare on 2015/10/31.
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {
    private int count;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        GoodsReq.GoodsRequest request = (GoodsReq.GoodsRequest) msg;
        System.out.println(request);
        if (request.getName().equals("lance")) {
            GoodsResp.GoodsResponse.Builder builder = GoodsResp.GoodsResponse.newBuilder();
            GoodsResp.GoodsResponse response = builder.setId(2)
                    .setName("lance response")
                    .setResponseCode("responseaaaa")
                    .setNum(100000000)
                    .build();
            ctx.writeAndFlush(response);
        }
        /*String message = (String) msg;

        System.out.println("time server order" + message + "; count is " + ++count);

        String currentTime = "query client time order".equalsIgnoreCase(message) ? new Date().toString() : "bad order";

        currentTime = currentTime +"##$";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

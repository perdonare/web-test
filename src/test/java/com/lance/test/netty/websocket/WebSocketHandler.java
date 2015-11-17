package com.lance.test.netty.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.CharSetUtils;
import sun.net.httpserver.DefaultHttpServerProvider;

import java.util.Date;

/**
 * Created by perdonare on 2015/11/15.
 */
public class WebSocketHandler extends SimpleChannelInboundHandler {
    private WebSocketServerHandshaker handShaker;
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        //第一次请求由http承载
        if (msg instanceof FullHttpMessage) {
            System.out.println("第一次连接 http");
            handleHttpMessage(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            System.out.println("socket 连接");
            handleWebSocketMessage(ctx, (WebSocketFrame) msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("读取完毕");
        ctx.flush();
    }

    private void handleHttpMessage(ChannelHandlerContext ctx, FullHttpRequest request) {
        if (!request.getDecoderResult().isSuccess() || (!"websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(ctx,request,new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }

        handShaker = new WebSocketServerHandshakerFactory("ws://localhost:8080/websocket",null,false)
                .newHandshaker(request);

        if (handShaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            handShaker.handshake(ctx.channel(),request);
        }
    }



    private void handleWebSocketMessage(ChannelHandlerContext ctx, WebSocketFrame frame) {
        // 判断是否关闭链路
        if (frame instanceof CloseWebSocketFrame) {
            handShaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            System.out.println("关闭连接");
            return;
        }

        // 判断是否是ping消息
        if (frame instanceof PingWebSocketFrame){
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            System.out.println("ping连接");
            return;
        }

        // 本例程仅支持文本编码
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported",frame.getClass().getName()));
        }

        String request = ((TextWebSocketFrame) frame).text();
        ctx.channel().write(new TextWebSocketFrame(request+",欢迎使用webSocket,现在时间是"+new Date().toString()));

    }

    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request, DefaultFullHttpResponse response) {
        //返回应答给客户端
        if (response.getStatus().code()!=200) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(response.getStatus().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(byteBuf);
            byteBuf.release();
            setContentLength(response,response.content().readableBytes());
        }

        //如果为非 keep-alive，关闭连接
        ChannelFuture future = ctx.channel().writeAndFlush(response);
        if (!(isKeepAlive(request)) || response.getStatus().code()!=200){
            System.out.println("keep alive 关闭连接");
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private boolean isKeepAlive(FullHttpRequest request) {
        return true;
       // return (request.headers().get("keep-alive").equals("true"))?true:false;
    }

    private void setContentLength(DefaultFullHttpResponse response, int i) {
        response.retain(i);
    }
}

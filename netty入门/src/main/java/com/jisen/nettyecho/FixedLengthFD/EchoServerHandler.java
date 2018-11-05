package com.jisen.nettyecho.FixedLengthFD;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import static io.netty.channel.ChannelHandler.Sharable;

/**
 * Created by jisen on 2018/2/9.
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive client["+msg+"]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

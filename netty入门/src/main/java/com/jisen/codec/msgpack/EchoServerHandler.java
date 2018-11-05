package com.jisen.codec.msgpack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import static io.netty.channel.ChannelHandler.Sharable;

/**
 * Created by jisen on 2018/2/9.
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private final int sendNumber;
    public EchoServerHandler(int sendNumber){
        this.sendNumber = sendNumber;
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Server receive the msgpack message :"+msg);
        ctx.write(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

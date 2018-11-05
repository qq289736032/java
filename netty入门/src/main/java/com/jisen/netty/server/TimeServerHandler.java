package com.jisen.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by jisen on 2018/10/30.
 */
@Sharable
public class TimeServerHandler extends ChannelInboundHandlerAdapter {


    private int counter;

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {

        String body = (String)msg;

        System.out.println("The time server receive order:"+body+";the counter is :" + ++counter);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
        currentTime = currentTime+System.getProperty("line.separator");

        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());

        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}

package com.jisen.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * Created by jisen on 2018/10/30.
 */
@Sharable
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = Logger.getLogger(TimeClientHandler.class);
    //private final ByteBuf firstMessage;
    private int counter;
    private byte[] req;

    /**
     * Create a client-side handler
     */
    public TimeClientHandler(){
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
//        byte[] bytes = "QUERY TIME ORDER".getBytes();
//        firstMessage = Unpooled.buffer(bytes.length);
//        firstMessage.writeBytes(bytes);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i=0;i<100;i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        String body = (String)msg;
        System.out.println("Now is :"+body+";the counter is : " + ++counter);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("Unexpected exception from downstream:" +cause.getMessage());
        ctx.close();
    }
}

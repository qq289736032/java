package com.jisen.TCPServer;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.Executors;

public class SocketHandler {
    public static volatile boolean ENCRIPI_DECRIPT = false;

    public void channelRead(final ChannelHandlerContext ctx,final Object msg){
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //if()
            }
        });
    }

    /**
     * 编解码过滤
     * @param val
     * @return
     */
    private String codeFilter(String val){

        return "";
    }

    private void dataHandle(final ChannelHandlerContext cxt,final Object msg){
        String body = (String)msg;
        body = codeFilter(body);
        //JSON.parseObject(body,ProtoMessage.class);
    }
}

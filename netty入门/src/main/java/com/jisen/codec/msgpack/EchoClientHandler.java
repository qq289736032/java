package com.jisen.codec.msgpack;

import com.jisen.nettyserializable.UserInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by jisen on 2018/11/1.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private final int sendNumber;
    public EchoClientHandler(int sendNumber){
        this.sendNumber = sendNumber;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] userInfo = userInfo();
        for (UserInfo infoE: userInfo) {
            ctx.write(infoE);
        }
        ctx.flush();
    }

    private UserInfo[] userInfo(){
        UserInfo[] userInfos = new UserInfo[sendNumber];
        UserInfo userInfo = null;
        for (int i=0;i<sendNumber;i++){
            userInfo = new UserInfo();
            userInfo.setUserID(i);
            userInfo.setUserName("ABCD--->"+i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msgpack :"+msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

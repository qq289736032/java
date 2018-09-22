package com.jisen.TCPServer;

import com.jisen.HttpServer.HttpServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class SocketServer {
    protected static Logger logger = Logger.getLogger(SocketServer.class);
    public static SocketServer inst;
    public static Properties p;
    public static String ip;
    public static int port;
    private NioEventLoopGroup bossGroup = new NioEventLoopGroup();
    private NioEventLoopGroup workGroup = new NioEventLoopGroup();

    private SocketServer(){}
    public static SocketServer getInstance(){
        if(inst == null){
            inst = new SocketServer();
            inst.initData();
        }
        return  inst;
    }

    public void initData() {
        try {
            p = readProperties();
            port = Integer.parseInt(p.getProperty("port"));
        } catch (IOException e) {
            logger.error("配置文件读取错误");
            e.printStackTrace();
        }
    }

    public void start(){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.option(ChannelOption.SO_BACKLOG,128);
        //通过禁用Nagle,使消息立即发出去,不用等到一定数据才发出去
        serverBootstrap.option(ChannelOption.TCP_NODELAY,true);
        serverBootstrap.option(ChannelOption.SO_REUSEADDR,true);

        //保持长连接状态
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                //业务逻辑处理
                pipeline.addLast((ChannelHandler) new SocketHandler());
            }
        });
        //启动端口
        ChannelFuture future;
        try {
            future = serverBootstrap.bind(port).sync();
            if(future.isSuccess()){
                logger.info("端口号已绑定"+port);
            }
        } catch (InterruptedException e) {
            logger.info("失败");
            e.printStackTrace();
        }
    }

    public void shut(){
        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        //关闭所有channel连接
        //ChannelMgr.getInstance().closeAllChannel();
    }

    /**
     * 读取配置文
     */
    protected Properties readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = HttpServer.class.getResourceAsStream("/net.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, Charset.forName("UTF-8"));
        properties.load(inputStreamReader);
        resourceAsStream.close();
        return properties;
    }
}

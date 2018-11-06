package com.jisen.HttpServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.concurrent.Executors;

public class HttpServer {
    protected static Logger logger = Logger.getLogger(HttpServer.class);
    public static HttpServer inst;
    public static Properties p;
    public static String ip;
    public static int port;
    public static String pvpIp;
    public static int pvpPort;
    private NioEventLoopGroup bossGroup = null;
    private NioEventLoopGroup workGroup = null;

    private HttpServer(){}

    /**
     * 获取实例
     * @return
     */
    public static HttpServer getInstance(){
        if(inst == null){
            inst = new HttpServer();
            inst.initData();
        }
        return inst;
    }

    /**
     * 初始化socket数据,port及ip,端口,
     */
    private void initData() {
        try {
            p=readProperties();
            ip = p.getProperty("ip");
            port = Integer.parseInt(p.getProperty("port"));
            pvpIp = p.getProperty("pvpIp");
            pvpPort = Integer.parseInt(p.getProperty("pvpPort"));
        } catch (IOException e) {
            logger.info("socket配置文件读取错误");
            e.printStackTrace();
        }
    }

    public void start(){
        bossGroup = new NioEventLoopGroup(0, Executors.newCachedThreadPool());//boss线程组
        workGroup = new NioEventLoopGroup(0, Executors.newCachedThreadPool());//work线程组
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                /**
                 * http request 解码
                 */
                pipeline.addLast("decoder",new HttpRequestDecoder());
                pipeline.addLast("aggregator",new HttpObjectAggregator(65536));
                /**
                 * http response 编码
                 */
                pipeline.addLast("encoder",new HttpResponseEncoder());
                pipeline.addLast("http-chunked",new ChunkedWriteHandler());

                /**
                 * http response handler
                 */
                pipeline.addLast("outbound",new HttpOutHandler());

                /**
                 * http request handler
                 */
                pipeline.addLast("intbound",new HttpInHandler());
            }
        });
        logger.info("端口{}已绑定"+port);
        serverBootstrap.bind(port);
    }

    public void shut() {
        if(bossGroup != null && workGroup != null){
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
        logger.info("端口解绑"+port);
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

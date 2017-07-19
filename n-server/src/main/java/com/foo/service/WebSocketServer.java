package com.foo.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;

/**
 * Created by jianguang he on 2017/7/19.
 */
public class WebSocketServer {

    public void start() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class) //指定所使用的NIO传输channel
                    .localAddress(new InetSocketAddress(1331)) //使用指定端口设置套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //添加一个EchoServerhandler到子channel的channelPipeLine
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("http-codec",new HttpServerCodec());
                            socketChannel.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
                            socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                            socketChannel.pipeline().addLast("handler",new WebSocketServerHandler());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            //异步的绑定服务器；调用sync()阻塞等待直到绑定完成
            channelFuture.channel().closeFuture().sync(); // 获取 Channel 的CloseFuture
            //并阻塞当前线程直到他完成
        }finally {
            eventLoopGroup.shutdownGracefully().sync();
            //关闭eventgroup释放所有资源
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new WebSocketServer().start();
    }
}

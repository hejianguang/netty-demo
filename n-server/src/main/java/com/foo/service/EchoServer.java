package com.foo.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by jianguang he on 2017/7/18.
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
//        if (args.length != 1){
//            System.err.println(
//                    "Usage: " + EchoServer.class.getSimpleName() + " <port>"
//            );
//        }
//        int port = Integer.parseInt(args[0]);
        new EchoServer(1332).start();
    }


    public void start() throws InterruptedException {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class) //指定所使用的NIO传输channel
                    .localAddress(new InetSocketAddress(port)) //使用指定端口设置套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //添加一个EchoServerhandler到子channel的channelPipeLine
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(echoServerHandler);
                            //EchoServerHandler被标注为Sharable,所以我们总是使用同样的实例
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

    /**
     * 该例子的步骤总结
     *
     EchoServerHandler 实现了业务逻辑；
     main()方法引导了服务器；
     引导过程中所需要的步骤如下：
     创建一个 ServerBootstrap 的实例以引导和绑定服务器；
     创建并分配一个 NioEventLoopGroup 实例以进行事件的处理，如接受新连接以及读/
     写数据；
     指定服务器绑定的本地的 InetSocketAddress；
     使用一个 EchoServerHandler 的实例初始化每一个新的 Channel；
     调用 ServerBootstrap.bind()方法以绑定服务器。
     */
}

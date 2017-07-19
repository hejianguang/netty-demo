package com.foo.service;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by jianguang he on 2017/7/18.
 *
 为初始化客户端，创建了一个 Bootstrap 实例；
 为进行事件处理分配了一个 NioEventLoopGroup 实例，其中事件处理包括创建新的
 连接以及处理入站和出站数据；
 为服务器连接创建了一个 InetSocketAddress 实例；
 当连接被建立时，一个 EchoClientHandler 实例会被安装到（该 Channel 的）
 ChannelPipeline 中；
 在一切都设置完成后，调用 Bootstrap.connect()方法连接到远程节点；
 完成了客户端，你便可以着手构建并测试该系统了
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(
                                    new EchoClienHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync(); //连接到远程节点，阻塞等待直到连接完成
            f.channel().closeFuture().sync(); //阻塞，直到Channel 关闭
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//            if (args.length != 2) {
//                System.err.println(
//                        "Usage: " + EchoClient.class.getSimpleName() +
//                                " <host> <port>");
//                return;
//            }
//            String host = args[0];
//            int port = Integer.parseInt(args[1]);
//            new EchoClient(host, port).start();
            new EchoClient("localhost", 1332).start();
    }
}

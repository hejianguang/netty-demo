package com.foo.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Created by jianguang he on 2017/7/18.
 *
 *客户端将拥有一个用来处理数据的 ChannelInboundHandler。在这个场景
 下，你将扩展 SimpleChannelInboundHandler 类以处理所有必须的任务，如代码清单 2-3
 所示。这要求重写下面的方法：
 channelActive()——在到服务器的连接已经建立之后将被调用；
 channelRead0()①
 @Sharable
 public class EchoClientHandler extends
 SimpleChannelInboundHandler<ByteBuf> {
 @Override
 public void channelActive(ChannelHandlerContext ctx) {
 ——当从服务器接收到一条消息时被调用；
 exceptionCaught()——在处理过程中引发异常时被调用。
 */
public class EchoClienHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 记录已接受消息的存储
     * @param channelHandlerContext
     * @param byteBuf
     * @throws Exception
    每当接收数据时，都会调用这个方法。需要注
    意的是，由服务器发送的消息可能会被分块接收。也就是说，如果服务器发送了 5 字节，那么不
    能保证这 5 字节会被一次性接收。即使是对于这么少量的数据， channelRead0()方法也可能
    会被调用两次，第一次使用一个持有 3 字节的 ByteBuf（Netty 的字节容器），第二次使用一个
    持有 2 字节的 ByteBuf。作为一个面向流的协议， TCP 保证了字节数组将会按照服务器发送它
    们的顺序被接收
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println(
                "client Received: " + byteBuf.toString(CharsetUtil.UTF_8)
        );
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
        //记录异常，关闭channel
    }
}

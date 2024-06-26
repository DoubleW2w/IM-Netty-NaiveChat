package com.doublew2w.naive.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 21:15
 * @project: IM-Netty-NaiveChat
 */
public class NettyServer {
  public static void main(String[] args) {
    new NettyServer().bing(7397);
  }

  private void bing(int port) {
    // 配置服务端NIO线程组
    EventLoopGroup parentGroup = new NioEventLoopGroup();
    EventLoopGroup childGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(parentGroup, childGroup)
          .channel(NioServerSocketChannel.class) // 非阻塞模式
          .option(ChannelOption.SO_BACKLOG, 128)
          .childHandler(new MyChannelInitializer());
      ChannelFuture f = b.bind(port).sync();
      System.out.println("itstack-demo-netty server start done");
      f.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      childGroup.shutdownGracefully();
      parentGroup.shutdownGracefully();
    }
  }
}

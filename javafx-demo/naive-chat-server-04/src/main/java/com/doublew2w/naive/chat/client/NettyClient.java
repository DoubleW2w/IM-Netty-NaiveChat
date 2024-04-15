package com.doublew2w.naive.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 21:15
 * @project: IM-Netty-NaiveChat
 */
public class NettyClient {

  public static void main(String[] args) {
    new NettyClient().connect("127.0.0.1", 7397);
  }

  private void connect(String inetHost, int inetPort) {
    NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(workerGroup)
          .channel(NioSocketChannel.class)
          .option(ChannelOption.AUTO_READ, true)
          .handler(new MyChannelInitializer());
      ChannelFuture f = b.connect(inetHost, inetPort).sync();
      System.out.println("itstack-demo-netty client start done");
      f.channel().closeFuture().sync();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      workerGroup.shutdownGracefully();
    }
  }
}

package com.doublew2w.naive.chat.ddd.socket;

import com.doublew2w.naive.chat.ddd.application.UserService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import java.util.concurrent.Callable;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 0:29
 * @project: IM-Netty-NaiveChat
 */
@Service
public class NettyServer implements Callable<Channel> {
  private Logger logger = LoggerFactory.getLogger(NettyServer.class);

  private final EventLoopGroup parentGroup = new NioEventLoopGroup(2);
  private final EventLoopGroup childGroup = new NioEventLoopGroup();
  private Channel channel;

  @Resource private UserService userService;

  @Override
  public Channel call() {
    ChannelFuture channelFuture = null;
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(parentGroup, childGroup)
          .channel(NioServerSocketChannel.class)
          .option(ChannelOption.SO_BACKLOG, 128)
          .childHandler(new MyChannelInitializer(userService));
      channelFuture = b.bind(new InetSocketAddress(7397)).syncUninterruptibly();
      this.channel = channelFuture.channel();
    } catch (Exception e) {
      logger.error("socket server start error:{}", e.getMessage(), e);
    } finally {
      if (null != channelFuture && channelFuture.isSuccess()) {
        logger.info("socket server start done. ");
      } else {
        logger.error("socket server start error. ");
      }
    }
    return channel;
  }

  /**
   * 关闭
   */
  public void destroy() {
    if (null == channel) {
	    return;
    }
    channel.close();
    parentGroup.shutdownGracefully();
    childGroup.shutdownGracefully();
  }

  public Channel channel() {
    return channel;
  }
}

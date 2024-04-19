package com.doublew2w.naive.chat.client.socket;

import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.client.infrastructure.util.BeanUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:14
 * @project: IM-Netty-NaiveChat
 */
public class NettyClient implements Callable<Channel> {
  private final Logger logger = LoggerFactory.getLogger(NettyClient.class);

  private final String inetHost = "127.0.0.1";
  private final int inetPort = 7397;

  private final EventLoopGroup workerGroup = new NioEventLoopGroup();
  private Channel channel;

  /** UI服务 */
  private UIService uiService;

  public NettyClient(UIService uiService) {
    this.uiService = uiService;
  }

  @Override
  public Channel call() throws Exception {
    ChannelFuture channelFuture = null;
    try {
      Bootstrap b = new Bootstrap();
      b.group(workerGroup)
          .channel(NioSocketChannel.class)
          .option(ChannelOption.AUTO_READ, true)
          .handler(new MyChannelInitializer(uiService));
      channelFuture = b.connect(inetHost, inetPort).syncUninterruptibly();
      this.channel = channelFuture.channel();
      // 添加通道缓存
      BeanUtil.addBean("channel", channel);
    } catch (Exception e) {
      logger.error("socket client start error:{}", e.getMessage(), e);
    } finally {
      if (null != channelFuture && channelFuture.isSuccess()) {
        logger.info("socket client start done. ");
      } else {
        logger.error("socket client start error. ");
      }
    }
    return channel;
  }

  public void destroy() {
    if (null == channel) return;
    channel.close();
    workerGroup.shutdownGracefully();
  }

  public boolean isActive() {
    return channel.isActive();
  }

  public Channel channel() {
    return channel;
  }
}

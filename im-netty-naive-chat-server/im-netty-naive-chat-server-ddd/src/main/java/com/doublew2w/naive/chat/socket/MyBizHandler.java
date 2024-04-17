package com.doublew2w.naive.chat.socket;

import com.doublew2w.naive.chat.application.UserService;
import com.doublew2w.naive.chat.infrastructure.util.SocketChannelUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 0:43
 * @project: IM-Netty-NaiveChat
 */
public abstract class MyBizHandler<T> extends SimpleChannelInboundHandler<T> {
  protected Logger logger = LoggerFactory.getLogger(MyBizHandler.class);

  protected UserService userService;

  public MyBizHandler(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    logger.info("客户端连接通知：{}", ctx.channel());
    super.channelActive(ctx);
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    super.channelInactive(ctx);
    SocketChannelUtil.removeChannel(ctx.channel().id().toString());
    SocketChannelUtil.removeChannelGroupByChannel(ctx.channel());
  }

  /**
   * 通信通道读取
   *
   * @param channel 通信通道
   * @param msg 对象
   */
  public abstract void channelRead(Channel channel, T msg);

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, T t) throws Exception {
    channelRead(channelHandlerContext.channel(), t);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.error("服务端异常断开：{}", cause.getMessage(), cause);
    SocketChannelUtil.removeChannel(ctx.channel().id().toString());
    SocketChannelUtil.removeChannelGroupByChannel(ctx.channel());
  }
}

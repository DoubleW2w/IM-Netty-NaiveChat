package com.doublew2w.naive.chat.socket;

import com.doublew2w.naive.chat.application.UserService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 0:32
 * @project: IM-Netty-NaiveChat
 */
public abstract class MyBizHandler<T> extends SimpleChannelInboundHandler<T> {

  protected Logger logger = LoggerFactory.getLogger(MyBizHandler.class);

  protected UserService userService;

  public MyBizHandler(UserService userService) {
    this.userService = userService;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception {
    channelRead(ctx.channel(), msg);
  }

  public abstract void channelRead(Channel channel, T msg);

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    super.channelActive(ctx);
    logger.info("客户端连接通知：{}", ctx.channel());
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    super.channelInactive(ctx);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.error("服务端异常断开", cause.getMessage());
  }

}

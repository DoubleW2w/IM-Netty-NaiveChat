package com.doublew2w.naive.chat.client.socket;

import com.doublew2w.naive.chat.client.application.UIService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:21
 * @project: IM-Netty-NaiveChat
 */
public abstract class MyBizHandler<T> extends SimpleChannelInboundHandler<T> {

  protected UIService uiService;

  public MyBizHandler(UIService uiService) {
    this.uiService = uiService;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception {
    channelRead(ctx.channel(), msg);
  }

  public abstract void channelRead(Channel channel, T msg);

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    super.channelInactive(ctx);
    System.out.println("断开连接了");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    System.out.println("关闭" + ctx.channel().id());
  }

}

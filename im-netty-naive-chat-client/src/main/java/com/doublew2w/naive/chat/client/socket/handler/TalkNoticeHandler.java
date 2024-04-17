package com.doublew2w.naive.chat.client.socket.handler;

import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.protocol.talk.TalkNoticeResponse;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:30
 * @project: IM-Netty-NaiveChat
 */
public class TalkNoticeHandler extends SimpleChannelInboundHandler<TalkNoticeResponse> {

  private UIService uiService;

  public TalkNoticeHandler(UIService uiService) {
    this.uiService = uiService;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, TalkNoticeResponse msg) throws Exception {
    IChatMethod chat = uiService.getChat();
    Platform.runLater(() -> {
      chat.addTalkBox(-1, 0, msg.getTalkId(), msg.getTalkName(), msg.getTalkHead(), msg.getTalkSketch(), msg.getTalkDate(), false);
    });
  }

}

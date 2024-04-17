package com.doublew2w.naive.chat.client.socket.handler;

import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.protocol.msg.MsgResponse;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:29
 * @project: IM-Netty-NaiveChat
 */
public class MsgHandler extends SimpleChannelInboundHandler<MsgResponse> {

  private UIService uiService;

  public MsgHandler(UIService uiService) {
    this.uiService = uiService;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MsgResponse msg) throws Exception {
    IChatMethod chat = uiService.getChat();
    Platform.runLater(() -> {
      chat.addTalkMsgUserLeft(msg.getFriendId(), msg.getMsgText(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
    });
  }

}


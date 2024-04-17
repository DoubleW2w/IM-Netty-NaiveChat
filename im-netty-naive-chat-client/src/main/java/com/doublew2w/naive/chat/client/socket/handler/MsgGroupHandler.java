package com.doublew2w.naive.chat.client.socket.handler;

import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.protocol.msg.MsgGroupResponse;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:29
 * @project: IM-Netty-NaiveChat
 */
public class MsgGroupHandler extends SimpleChannelInboundHandler<MsgGroupResponse> {

  private UIService uiService;

  public MsgGroupHandler(UIService uiService) {
    this.uiService = uiService;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MsgGroupResponse msg) throws Exception {
    IChatMethod chat = uiService.getChat();
    Platform.runLater(() -> {
      chat.addTalkMsgGroupLeft(msg.getTalkId(), msg.getUserId(), msg.getUserNickName(), msg.getUserHead(), msg.getMsg(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
    });
  }

}

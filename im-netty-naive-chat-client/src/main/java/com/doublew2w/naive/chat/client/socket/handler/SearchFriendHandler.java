package com.doublew2w.naive.chat.client.socket.handler;

import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.protocol.friend.SearchFriendResponse;
import com.doublew2w.naive.chat.protocol.friend.dto.UserDto;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.List;
import javafx.application.Platform;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:30
 * @project: IM-Netty-NaiveChat
 */
public class SearchFriendHandler extends SimpleChannelInboundHandler<SearchFriendResponse> {

  private UIService uiService;

  public SearchFriendHandler(UIService uiService) {
    this.uiService = uiService;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, SearchFriendResponse msg) throws Exception {
    List<UserDto> list = msg.getList();
    if (null == list || list.isEmpty()) return;
    IChatMethod chat = uiService.getChat();
    Platform.runLater(() -> {
      for (UserDto user : list) {
        chat.addLuckFriend(user.getUserId(), user.getUserNickName(), user.getUserHead(), user.getStatus());
      }
    });
  }

}

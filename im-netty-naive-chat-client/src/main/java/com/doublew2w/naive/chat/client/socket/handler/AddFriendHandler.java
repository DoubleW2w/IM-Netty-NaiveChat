package com.doublew2w.naive.chat.client.socket.handler;

import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.client.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.friend.AddFriendResponse;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import io.netty.channel.Channel;
import javafx.application.Platform;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:29
 * @project: IM-Netty-NaiveChat
 */
public class AddFriendHandler extends MyBizHandler<AddFriendResponse> {

  public AddFriendHandler(UIService uiService) {
    super(uiService);
  }

  @Override
  public void channelRead(Channel channel, AddFriendResponse msg) {
    IChatMethod chat = uiService.getChat();
    Platform.runLater(
        () -> {
          chat.addFriendUser(true, msg.getFriendId(), msg.getFriendNickName(), msg.getFriendHead());
        });
  }
}

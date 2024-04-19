package com.doublew2w.naive.chat.ddd.socket.handler;

import com.doublew2w.naive.chat.ddd.application.UserService;
import com.doublew2w.naive.chat.ddd.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.talk.DelTalkRequest;
import io.netty.channel.Channel;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 17:08
 * @project: IM-Netty-NaiveChat
 */
public class DelTalkHandler extends MyBizHandler<DelTalkRequest> {

  public DelTalkHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, DelTalkRequest msg) {
    userService.deleteUserTalk(msg.getUserId(), msg.getTalkId());
  }
}

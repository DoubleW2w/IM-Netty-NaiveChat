package com.doublew2w.naive.chat.socket.handler;

import com.doublew2w.naive.chat.application.UserService;
import com.doublew2w.naive.chat.protocol.login.LoginRequest;
import com.doublew2w.naive.chat.socket.MyBizHandler;
import io.netty.channel.Channel;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 0:43
 * @project: IM-Netty-NaiveChat
 */
public class LoginHandler extends MyBizHandler<LoginRequest> {

  public LoginHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, LoginRequest msg) {
    // 登录请求接收
    // 处理
  }
}

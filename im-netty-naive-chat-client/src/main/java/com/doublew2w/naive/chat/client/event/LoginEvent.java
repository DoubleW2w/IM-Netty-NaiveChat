package com.doublew2w.naive.chat.client.event;

import com.doublew2w.naive.chat.client.infrastructure.util.BeanUtil;
import com.doublew2w.naive.chat.client.infrastructure.util.CacheUtil;
import com.doublew2w.naive.chat.protocol.login.LoginRequest;
import com.doublew2w.naive.chat.ui.view.login.ILoginEvent;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录事件实现
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 14:37
 * @project: IM-Netty-NaiveChat
 */
public class LoginEvent implements ILoginEvent {
  private Logger logger = LoggerFactory.getLogger(LoginEvent.class);

  @Override
  public void doLoginCheck(String userId, String userPassword) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new LoginRequest(userId, userPassword));
    CacheUtil.userId = userId;
  }
}

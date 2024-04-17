package com.doublew2w.naive.chat.client.application;

import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import com.doublew2w.naive.chat.ui.view.login.ILoginMethod;
import lombok.Getter;
import lombok.Setter;

/**
 * 网络服务
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 23:15
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UIService {
  /** 登录方法 */
  private ILoginMethod login;

  /** 聊天方法 */
  private IChatMethod chat;
}

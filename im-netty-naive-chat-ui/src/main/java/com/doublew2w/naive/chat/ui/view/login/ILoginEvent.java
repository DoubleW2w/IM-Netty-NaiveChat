package com.doublew2w.naive.chat.ui.view.login;

/**
 * UI-登录接口定义，外部给予实现
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 14:39
 * @project: IM-Netty-NaiveChat
 */
public interface ILoginEvent {
  /**
   * 登录验证
   *
   * @param userId 用户Id
   * @param userPassword 用户密码
   */
  void doLoginCheck(String userId, String userPassword);
}

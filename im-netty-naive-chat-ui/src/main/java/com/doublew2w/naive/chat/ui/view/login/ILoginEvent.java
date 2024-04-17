package com.doublew2w.naive.chat.ui.view.login;

/**
 * UI-登录窗体事件接口
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

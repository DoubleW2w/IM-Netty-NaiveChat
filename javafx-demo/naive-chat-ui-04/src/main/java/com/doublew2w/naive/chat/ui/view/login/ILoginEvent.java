package com.doublew2w.naive.chat.ui.view.login;

/**
 * 登陆窗体实现，外部给予实现
 *
 * <p>事件接口类，点击登陆后属于窗体的功能处理完毕后，实际的验证交给外部
 *
 * @author: DoubleW2w
 * @description: 登陆窗体实现
 * @date: 2024/4/10 21:51
 * @project: IM-Netty-NaiveChat
 */
public interface ILoginEvent {

  /**
   * 登陆验证
   *
   * @param userId 用户ID
   * @param userPassword 用户密码
   */
  void doLoginCheck(String userId, String userPassword);
}

package com.doublew2w.naive.chat.ui.view.login;

/**
 * 登陆事件接口类
 *
 * <p>具体实现交给调用方
 *
 * <p>1. 登陆校验
 *
 * @author: DoubleW2w
 * @description:
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

package com.doublew2w.naive.chat.ui.view.login;

/**
 * 登录窗体点击后的出发的接口方法
 *
 * <p>数据填充或者窗体切换
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:44
 * @project: IM-Netty-NaiveChat
 */
public interface ILoginMethod {
  /** 打开登陆窗口 */
  void doShow();

  /** 登陆失败 */
  void doLoginError();

  /** 登陆成功；跳转聊天窗口[关闭登陆窗口，打开新窗口] */
  void doLoginSuccess();
}

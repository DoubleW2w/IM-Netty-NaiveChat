package com.doublew2w.naive.chat.ui.view.login;

/**
 * 方法接口类
 *
 * <p>登陆处理完毕后来执行对应的方法，进行窗口切换或者数据填充
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 21:55
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

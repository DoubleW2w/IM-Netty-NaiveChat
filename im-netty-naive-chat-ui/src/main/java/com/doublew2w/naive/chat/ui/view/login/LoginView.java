package com.doublew2w.naive.chat.ui.view.login;

/**
 * 登录窗体的展示
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:54
 * @project: IM-Netty-NaiveChat
 */
public class LoginView {
  /** 登录初始化行为 */
  private LoginInit loginInit;

  /** 登录事件接口类 */
  private ILoginEvent loginEvent;

  public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
    this.loginInit = loginInit;
    this.loginEvent = loginEvent;
  }
}

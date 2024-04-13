package com.doublew2w.naive.chat.ui.view.login;

/**
 * 窗体的展示
 *
 * @author: DoubleW2w
 * @description: 页面展示元素和事件定义
 * @date: 2024/4/10 22:12
 * @project: IM-Netty-NaiveChat
 */
public class LoginView {
  private LoginInit loginInit;
  private ILoginEvent loginEvent;

  public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
    this.loginInit = loginInit;
    this.loginEvent = loginEvent;
  }
}

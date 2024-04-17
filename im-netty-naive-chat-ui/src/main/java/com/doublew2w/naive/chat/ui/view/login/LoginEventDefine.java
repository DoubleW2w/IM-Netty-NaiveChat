package com.doublew2w.naive.chat.ui.view.login;

/**
 * 窗体事件定义：登录、最小化、退出
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:56
 * @project: IM-Netty-NaiveChat
 */
public class LoginEventDefine {
  /** 登录初始化操作 */
  private LoginInit loginInit;

  /** 登录窗体事件定义 */
  private ILoginEvent loginEvent;

  /** 登录创方法定义 */
  private ILoginMethod loginMethod;

  public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
    this.loginInit = loginInit;
    this.loginEvent = loginEvent;
    this.loginMethod = loginMethod;

    loginInit.move();
    min();
    quit();
    doEventLogin();
  }

  // 事件；最小化
  private void min() {
    loginInit.login_min.setOnAction(
        event -> {
          loginInit.setIconified(true);
        });
  }

  // 事件；退出
  private void quit() {
    loginInit.login_close.setOnAction(
        event -> {
          loginInit.close();
          System.exit(0);
        });
  }

  // 事件；登陆
  private void doEventLogin() {
    loginInit.login_button.setOnAction(
        event -> {
          loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
        });
  }
}

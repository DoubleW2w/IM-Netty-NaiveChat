package com.doublew2w.naive.chat.ui.view.login;

/**
 * 窗体事件定义
 *
 * <p>事件定义完成后，都会交给构造方法进行初始化。
 *
 * @author: DoubleW2w
 * @description: 窗体事件定义
 * @date: 2024/4/10 21:58
 * @project: IM-Netty-NaiveChat
 */
public class LoginEventDefine {

  private LoginInit loginInit;
  private ILoginEvent loginEvent;
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

  /** 事件；最小化 */
  private void min() {
    // 最小化按钮执行事件：最小化
    loginInit.loginMin.setOnAction(
        event -> {
          System.out.println("最小化");
          loginInit.setIconified(true);
        });
  }

  /** 事件；退出 */
  private void quit() {
    loginInit.loginClose.setOnAction(
        event -> {
          System.out.println("退出");
          loginInit.close();
          System.exit(0);
        });
  }

  /** 事件；登陆 */
  private void doEventLogin() {
    loginInit.loginButton.setOnAction(
        event -> {
          loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
        });
  }
}

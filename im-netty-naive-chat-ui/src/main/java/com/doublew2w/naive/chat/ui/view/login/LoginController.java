package com.doublew2w.naive.chat.ui.view.login;

import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;

/**
 * 窗体的控制管理类
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:59
 * @project: IM-Netty-NaiveChat
 */
public class LoginController extends LoginInit implements ILoginMethod {

  private IChatMethod chat;
  private LoginView loginView;
  private LoginEventDefine loginEventDefine;

  public LoginController(ILoginEvent loginEvent, IChatMethod chat) {
    super(loginEvent);
    this.chat = chat;
  }

  @Override
  public void initView() {
    loginView = new LoginView(this, loginEvent);
  }

  @Override
  public void initEventDefine() {
    loginEventDefine = new LoginEventDefine(this, loginEvent, this);
  }

  @Override
  public void doShow() {
    super.show();
  }

  @Override
  public void doLoginError() {
    System.out.println("登陆失败，执行提示操作");
  }

  @Override
  public void doLoginSuccess() {
    // 关闭原窗口
    close();
    // 打开聊天窗口
    chat.doShow();
  }
}

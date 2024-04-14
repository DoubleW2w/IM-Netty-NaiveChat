package com.doublew2w.naive.chat.ui.view.login;

import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;

/**
 * 窗口
 *
 * @author: DoubleW2w
 * @description: 窗口控制管理类
 * @date: 2024/4/10 21:56
 * @project: IM-Netty-NaiveChat
 */
public class LoginController extends LoginInit implements ILoginMethod {
  /** 登陆页面 */
  private LoginView loginView;

  /** 聊天窗口方法 */
  private IChatMethod chat;

  /** 登陆事件定义 */
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
    System.out.println("登陆成功，执行跳转操作");
    // 关闭原窗口
    close();
  }
}

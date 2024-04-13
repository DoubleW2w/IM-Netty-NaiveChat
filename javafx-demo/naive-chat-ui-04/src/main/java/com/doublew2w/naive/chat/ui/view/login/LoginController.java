package com.doublew2w.naive.chat.ui.view.login;

/**
 * 窗口控制管理类，也是一个窗体的管理
 *
 * <p>继承窗体的装载，实现接口方法，初始化界面，初始化事件定义
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 21:56
 * @project: IM-Netty-NaiveChat
 */
public class LoginController extends LoginInit implements ILoginMethod {
  private LoginView loginView;
  private LoginEventDefine loginEventDefine;

  public LoginController(ILoginEvent loginEvent) {
    super(loginEvent);
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

package com.doublew2w.naive.chat.ui.view.login;

import com.doublew2w.naive.chat.ui.view.UIObject;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * 窗体的初始化操作
 *
 * <p>1.创建一些待填充的元素
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 21:56
 * @project: IM-Netty-NaiveChat
 */
public abstract class LoginInit extends UIObject {
  /** 登陆fxml资源文件 */
  private static final String RESOURCE_NAME = "/fxml/login/login.fxml";

  /** 登陆事件接口 */
  protected ILoginEvent loginEvent;

  /** 登陆窗口最小化 */
  public Button loginMin;

  /** 登陆窗口退出 */
  public Button loginClose;

  /** 登陆按钮 */
  public Button loginButton;

  /** 用户账户窗口 */
  public TextField userId;

  /** 用户密码窗口 */
  public PasswordField userPassword;

  LoginInit(ILoginEvent loginEvent) {
    this.loginEvent = loginEvent;
    // 1.加载资源文件
    try {
      root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(RESOURCE_NAME)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 场景初始化
    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    setScene(scene);
    initStyle(StageStyle.TRANSPARENT);
    setResizable(false);
    this.getIcons().add(new Image("/fxml/login/img/system/logo.png"));
    // 登陆窗体包含的内容
    obtain();
    // 初始化窗体展示
    initView();
    // 初始化数据定义
    initEventDefine();
  }

  /** 窗体内容 */
  private void obtain() {
    loginMin = $("login_min", Button.class);
    loginClose = $("login_close", Button.class);
    loginButton = $("login_button", Button.class);
    userId = $("userId", TextField.class);
    userPassword = $("userPassword", PasswordField.class);
  }
}

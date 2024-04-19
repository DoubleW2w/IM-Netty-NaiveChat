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
 * 登录窗体的初始化操作
 *
 * <p>创建一些待填充的元素、加载资源文件
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:45
 * @project: IM-Netty-NaiveChat
 */
public abstract class LoginInit extends UIObject {
  private static final String RESOURCE_NAME = "/fxml/login/login.fxml";

  protected ILoginEvent loginEvent;

  /** 登录按钮 */
  public Button login_min;

  /** 登录窗口关闭按钮 */
  public Button login_close;

  /** 登录窗口登录按钮 */
  public Button login_button;

  /** 用户 */
  public TextField userId;

  /** 密码 */
  public PasswordField userPassword;

  LoginInit(ILoginEvent loginEvent) {
    this.loginEvent = loginEvent;
    try {
      root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(RESOURCE_NAME)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    setScene(scene);
    initStyle(StageStyle.TRANSPARENT);
    setResizable(false);
    this.getIcons().add(new Image("/fxml/chat/img/head/logo.png"));
    obtain();
    initView();
    initEventDefine();
  }

  private void obtain() {
    login_min = $("login_min", Button.class);
    login_close = $("login_close", Button.class);
    login_button = $("login_button", Button.class);
    userId = $("userId", TextField.class);
    userPassword = $("userPassword", PasswordField.class);
  }
}

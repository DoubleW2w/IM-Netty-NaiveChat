package com.doublew2w.naive.chat.ui.view;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/9 0:04
 * @project: IM-Netty-NaiveChat
 */
public class Login extends Stage {
  private static final String RESOURCE_NAME = "/fxml/login/login.fxml";

  private Parent root;

  public Login() {
    try {
      // 读取配置文件
      root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(RESOURCE_NAME)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 初始化窗体
    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    setScene(scene);
    initStyle(StageStyle.TRANSPARENT);
    setResizable(false);
    this.getIcons().add(new Image("/fxml/login/img/system/logo.png"));

      // 初始化事件
      initEvent();
  }

  public <T> T $(String id, Class<T> clazz) {
    return (T) root.lookup("#" + id);
  }

  public void doLoginError() {
    System.out.println("登陆失败，执行提示操作");
  }

  public void doLoginSuccess() {
    System.out.println("登陆成功，执行跳转操作");
  }

  private void initEvent() {
    this.move();
    this.min();
    this.quit();
    this.login();
  }

  private double xOffset;
  private double yOffset;

  /** 移动窗体 */
  private void move() {
    root.setOnMousePressed(
        event -> {
          xOffset = getX() - event.getScreenX();
          yOffset = getY() - event.getScreenY();
          root.setCursor(Cursor.CLOSED_HAND);
        });
    root.setOnMouseDragged(
        event -> {
          setX(event.getScreenX() + xOffset);
          setY(event.getScreenY() + yOffset);
        });
    root.setOnMouseReleased(
        event -> {
          root.setCursor(Cursor.DEFAULT);
        });
  }

  /** 事件；最小化 */
  private void min() {
    Button login_min = $("login_min", Button.class);
    login_min.setOnAction(
        event -> {
          System.out.println("最小化窗体");
          setIconified(true);
        });
  }

  /** 事件；退出 */
  private void quit() {
    Button login_close = $("login_close", Button.class);
    login_close.setOnAction(
        event -> {
          System.out.println("退出窗体");
          close();
          System.exit(0);
        });
  }

  /** 事件；登陆 */
  private void login() {

    TextField userId = $("userId", TextField.class);
    PasswordField userPassword = $("userPassword", PasswordField.class);

    $("login_button", Button.class)
        .setOnAction(
            event -> {
              System.out.println("登陆操作");
              System.out.println("用户ID：" + userId.getText());
              System.out.println("用户密码：" + userPassword.getText());
            });
  }
}

package com.doublew2w.naive.chat.ui;

import com.doublew2w.naive.chat.ui.view.login.ILoginMethod;
import com.doublew2w.naive.chat.ui.view.login.LoginController;
import javafx.stage.Stage;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/8 23:54
 * @project: IM-Netty-NaiveChat
 */
public class Application extends javafx.application.Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    ILoginMethod login =
        new LoginController(
            (userId, userPassword) -> {
              System.out.println("登陆 userId：" + userId + "userPassword：" + userPassword);
            });

    login.doShow();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

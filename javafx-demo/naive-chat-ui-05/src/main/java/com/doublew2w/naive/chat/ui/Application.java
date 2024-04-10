package com.doublew2w.naive.chat.ui;

import com.doublew2w.naive.chat.ui.view.chat.ChatController;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
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

    IChatMethod chat = new ChatController();
    chat.doShow();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

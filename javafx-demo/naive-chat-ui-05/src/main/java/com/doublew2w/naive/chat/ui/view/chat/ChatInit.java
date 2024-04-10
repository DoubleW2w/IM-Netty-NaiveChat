package com.doublew2w.naive.chat.ui.view.chat;

import com.doublew2w.naive.chat.ui.view.UIObject;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * 聊天窗口的初始化操作
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 23:41
 * @project: IM-Netty-NaiveChat
 */
public abstract class ChatInit extends UIObject {
  private static final String RESOURCE_NAME = "/fxml/chat/chat.fxml";

  ChatInit() {
    try {
      root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(RESOURCE_NAME)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 设置场景
    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    setScene(scene);
    initStyle(StageStyle.TRANSPARENT);
    setResizable(false);
    // 设置图标
    this.getIcons().add(new Image("/fxml/chat/img/head/logo.png"));
    // 初始化页面
    initView();
    // 初始化事件定义
    initEventDefine();
  }
}

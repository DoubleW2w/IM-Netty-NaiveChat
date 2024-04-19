package com.doublew2w.naive.chat.ui.view.chat;

import com.doublew2w.naive.chat.ui.view.UIObject;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:40
 * @project: IM-Netty-NaiveChat
 */
public abstract class ChatInit extends UIObject {
  private static final String RESOURCE_NAME = "/fxml/chat/chat.fxml";

  public String userId; // 用户ID
  public String userNickName; // 用户昵称
  public String userHead; // 用户头像

  public IChatEvent chatEvent;

  public TextArea txt_input; // 输入框

  ChatInit(IChatEvent chatEvent) {
    this.chatEvent = chatEvent;
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
    // 可以预加载
    txt_input = $("txt_input", TextArea.class);
  }

  public Parent root() {
    return super.root;
  }
}

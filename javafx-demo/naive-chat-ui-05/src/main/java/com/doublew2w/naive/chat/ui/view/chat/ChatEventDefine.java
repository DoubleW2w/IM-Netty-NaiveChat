package com.doublew2w.naive.chat.ui.view.chat;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * 聊天窗口事件定义
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 23:44
 * @project: IM-Netty-NaiveChat
 */
public class ChatEventDefine {

  private ChatInit chatInit;

  public ChatEventDefine(ChatInit chatInit) {
    this.chatInit = chatInit;

    chatInit.move();
    this.barChat();
    this.barFriend();
  }

  /**
   * 条形Bar聊天框体事件
   *
   * <p>设置鼠标事件：点击、移入、移除
   *
   * <p>在点击的时候切换窗体，移入和移除分别展示不同的背景图
   */
  private void barChat() {
    Button bar_chat = chatInit.$("bar_chat", Button.class);
    Pane group_bar_chat = chatInit.$("group_bar_chat", Pane.class);
    bar_chat.setOnAction(
        event -> {
          switchBarChat(bar_chat, group_bar_chat, true);
          switchBarFriend(
              chatInit.$("bar_friend", Button.class),
              chatInit.$("group_bar_friend", Pane.class),
              false);
        });
    bar_chat.setOnMouseEntered(
        event -> {
          boolean visible = group_bar_chat.isVisible();
          if (visible) return;
          bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_1.png')");
        });
    bar_chat.setOnMouseExited(
        event -> {
          boolean visible = group_bar_chat.isVisible();
          if (visible) return;
          bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_0.png')");
        });
  }

  /** 条形Bar好友框体事件 */
  private void barFriend() {
    Button bar_friend = chatInit.$("bar_friend", Button.class);
    Pane group_bar_friend = chatInit.$("group_bar_friend", Pane.class);
    bar_friend.setOnAction(
        event -> {
          switchBarChat(
              chatInit.$("bar_chat", Button.class),
              chatInit.$("group_bar_chat", Pane.class),
              false);
          switchBarFriend(bar_friend, group_bar_friend, true);
        });
    bar_friend.setOnMouseEntered(
        event -> {
          boolean visible = group_bar_friend.isVisible();
          if (visible) return;
          bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_1.png')");
        });
    bar_friend.setOnMouseExited(
        event -> {
          boolean visible = group_bar_friend.isVisible();
          if (visible) return;
          bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_0.png')");
        });
  }

  /**
   * 切换聊天窗体方法
   *
   * <p>根据toggle条件，定义样式的图片以及两个框体的隐藏和展现。
   *
   * @param bar_chat 条形Bar按钮
   * @param group_bar_chat 条形Bar组
   * @param toggle 切换
   */
  private void switchBarChat(Button bar_chat, Pane group_bar_chat, boolean toggle) {
    if (toggle) {
      bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_2.png')");
      group_bar_chat.setVisible(true);
    } else {
      bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_0.png')");
      group_bar_chat.setVisible(false);
    }
  }

  /**
   * 切换好友窗体
   *
   * @param bar_friend 好友窗体按钮
   * @param group_bar_friend 好友窗体组
   * @param toggle 切换
   */
  private void switchBarFriend(Button bar_friend, Pane group_bar_friend, boolean toggle) {
    if (toggle) {
      bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_2.png')");
      group_bar_friend.setVisible(true);
    } else {
      bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_0.png')");
      group_bar_friend.setVisible(false);
    }
  }
}

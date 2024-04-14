package com.doublew2w.naive.chat.ui.view.chat;

import com.doublew2w.naive.chat.ui.view.chat.data.TalkBoxData;
import java.util.Date;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
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
  private IChatEvent chatEvent;
  private IChatMethod chatMethod;

  public ChatEventDefine(ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
    this.chatInit = chatInit;
    this.chatEvent = chatEvent;
    this.chatMethod = chatMethod;

    chatInit.move();
    min(); // 最小化
    quit(); // 退出
    barChat(); // 聊天
    barFriend(); // 好友
    doEventTextSend(); // 发送消息事件[键盘]
    doEventTouchSend(); //
  }

  /** 发送消息事件[按钮] */
  private void doEventTouchSend() {
    Label touch_send = chatInit.$("touch_send", Label.class);
    touch_send.setOnMousePressed(
        event -> {
          doEventSendMsg();
        });
  }

  /** 发送消息事件[键盘] */
  private void doEventTextSend() {
    TextArea txt_input = chatInit.$("txt_input", TextArea.class);
    txt_input.setOnKeyPressed(
        event -> {
          if (event.getCode().equals(KeyCode.ENTER)) {
            doEventSendMsg();
          }
        });
  }

  private void doEventSendMsg() {
    TextArea txt_input = chatInit.$("txt_input", TextArea.class);
    String msg = txt_input.getText();
    if (null == msg || msg.isEmpty() || msg.trim().isEmpty()) {
      return;
    }

    MultipleSelectionModel selectionModel =
        chatInit.$("talkList", ListView.class).getSelectionModel();
    Pane selectedItem = (Pane) selectionModel.getSelectedItem();
    // 对话信息
    TalkBoxData talkBoxData = (TalkBoxData) selectedItem.getUserData();
    Date msgDate = new Date();
    // 发送消息
    System.out.println("发送消息：" + msg);
    // 发送事件给自己添加消息
    chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), msg, msgDate, true, true, false);
    txt_input.clear();
  }

  /** 退出 */
  private void quit() {
    chatInit
        .$("group_bar_chat_close", Button.class)
        .setOnAction(
            event -> {
              chatInit.close();
              System.exit(0);
              System.out.println("退出");
            });
  }

  /** 最小化 */
  private void min() {
    chatInit
        .$("group_bar_chat_min", Button.class)
        .setOnAction(
            event -> {
              chatInit.setIconified(true);
            });
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

  /**
   * 群组；开启与群组发送消息
   *
   * <p>点击鼠标事件后，填充群组信息到面板中
   *
   * @param sendMsgButton 发送按钮
   * @param groupId 群组id
   * @param groupName 群组名称
   * @param groupHead 群组头像
   */
  public void doEventOpenFriendGroupSendMsg(
      Button sendMsgButton, String groupId, String groupName, String groupHead) {
    sendMsgButton.setOnAction(
        event -> {
          // 1. 添加好友到对话框
          chatMethod.addTalkBox(0, 1, groupId, groupName, groupHead, null, null, true);
          // 2. 切换到对话框窗口
          switchBarChat(
              chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), true);
          switchBarFriend(
              chatInit.$("bar_friend", Button.class),
              chatInit.$("group_bar_friend", Pane.class),
              false);
          // 3. 事件处理；填充到对话框
          System.out.println("事件处理；填充到对话框");
        });
  }

  /**
   * 好友；开启与好友发送消息
   *
   * <p>[点击发送消息时候触发 -> 添加到对话框、选中、展示对话列表]
   *
   * @param sendMsgButton 发送消息按钮
   * @param userFriendId 好友id
   * @param userFriendNickName 好友昵称
   * @param userFriendHead 好友头像
   */
  public void doEventOpenFriendUserSendMsg(
      Button sendMsgButton, String userFriendId, String userFriendNickName, String userFriendHead) {
    sendMsgButton.setOnAction(
        event -> {
          // 1. 添加好友到对话框
          chatMethod.addTalkBox(
              0, 0, userFriendId, userFriendNickName, userFriendHead, null, null, true);
          // 2. 切换到对话框窗口
          switchBarChat(
              chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), true);
          switchBarFriend(
              chatInit.$("bar_friend", Button.class),
              chatInit.$("group_bar_friend", Pane.class),
              false);
          // 3. 事件处理；填充到对话框
          System.out.println("事件处理；填充到对话框");
        });
  }
}

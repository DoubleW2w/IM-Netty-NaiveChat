package com.doublew2w.naive.chat.ui.view.chat;

import com.doublew2w.naive.chat.ui.view.chat.data.RemindCount;
import com.doublew2w.naive.chat.ui.view.chat.data.TalkBoxData;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

/**
 * 聊天窗口展示类
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/11 0:13
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ChatView {
  private ChatInit chatInit;
  private IChatEvent chatEvent;

  public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
    this.chatInit = chatInit;
    this.chatEvent = chatEvent;
  }

  /**
   * 更新对话框列表元素位置指定并选中 [在聊天消息发送时触达]
   *
   * @param talkType 对话框类型[0好友、1群组]
   * @param talkElementPane 对话框元素面板
   * @param msgRemindLabel 消息提醒标签
   * @param idxFirst 是否设置首位
   * @param selected 是否选中
   * @param isRemind 是否提醒
   */
  void updateTalkListIdxAndSelected(
      int talkType,
      Pane talkElementPane,
      Label msgRemindLabel,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind) {
    // 对话框ID、好友ID
    TalkBoxData talkBoxData = (TalkBoxData) talkElementPane.getUserData();
    // 填充到对话框
    ListView<Pane> talkList = chatInit.$("talkList", ListView.class);

    // 对话空为空，初始化[置顶、选中、提醒]
    if (talkList.getItems().isEmpty()) {
      if (idxFirst) {
        talkList.getItems().add(0, talkElementPane);
      }
      if (selected) {
        // 设置对话框[√选中]
        talkList.getSelectionModel().select(talkElementPane);
      }
      isRemind(msgRemindLabel, talkType, isRemind);
      return;
    }

    // 对话空不为空，判断第一个元素是否当前聊天Pane
    Pane firstPane = talkList.getItems().get(0);
    // 判断元素是否在首位，如果是首位可返回不需要重新设置首位
    if (talkBoxData.getTalkId().equals(((TalkBoxData) firstPane.getUserData()).getTalkId())) {
      Pane selectedItem = talkList.getSelectionModel().getSelectedItem();
      // 选中判断；如果第一个元素已经选中[说明正在会话]，那么清空消息提醒
      if (null == selectedItem) {
        isRemind(msgRemindLabel, talkType, isRemind);
        return;
      }
      TalkBoxData selectedItemUserData = (TalkBoxData) selectedItem.getUserData();
      if (null != selectedItemUserData
          && talkBoxData.getTalkId().equals(selectedItemUserData.getTalkId())) {
        clearRemind(msgRemindLabel);
      } else {
        isRemind(msgRemindLabel, talkType, isRemind);
      }
      return;
    }
    if (idxFirst) {
      talkList.getItems().remove(talkElementPane);
      talkList.getItems().add(0, talkElementPane);
    }
    if (selected) {
      // 设置对话框[√选中]
      talkList.getSelectionModel().select(talkElementPane);
    }
    isRemind(msgRemindLabel, talkType, isRemind);
  }

  /**
   * 消息提醒
   *
   * @param msgRemindLabel 消息面板
   * @param talkType 对话框类型[0好友、1群组]
   * @param isRemind 是否提醒
   */
  private void isRemind(Label msgRemindLabel, int talkType, Boolean isRemind) {
    if (!isRemind) return;
    // 消息提醒标志展示
    msgRemindLabel.setVisible(true);
    // 群组直接展示小红点
    if (1 == talkType) {
      return;
    }
    // 个人展示「具体消息数字」或者「...」
    RemindCount remindCount = (RemindCount) msgRemindLabel.getUserData();
    // 超过10个展示省略号
    if (remindCount.getCount() > 99) {
      msgRemindLabel.setText("···");
      return;
    }
    // 展示具体数字
    int count = remindCount.getCount() + 1;
    msgRemindLabel.setUserData(new RemindCount(count));
    msgRemindLabel.setText(String.valueOf(count));
  }

  /**
   * 清除消息提醒
   *
   * @param msgRemindLabel 消息面板
   */
  private void clearRemind(Label msgRemindLabel) {
    msgRemindLabel.setVisible(false);
    msgRemindLabel.setUserData(new RemindCount(0));
  }
}

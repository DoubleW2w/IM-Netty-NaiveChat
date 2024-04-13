package com.doublew2w.naive.chat.ui.view.chat;

import com.doublew2w.naive.chat.ui.util.CacheUtil;
import com.doublew2w.naive.chat.ui.util.Ids;
import com.doublew2w.naive.chat.ui.view.chat.data.GroupsData;
import com.doublew2w.naive.chat.ui.view.chat.data.RemindCount;
import com.doublew2w.naive.chat.ui.view.chat.data.TalkData;
import com.doublew2w.naive.chat.ui.view.chat.element.group_bar_chat.ElementInfoBox;
import com.doublew2w.naive.chat.ui.view.chat.element.group_bar_chat.ElementTalk;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * 聊天的控制器类
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 23:42
 * @project: IM-Netty-NaiveChat
 */
public class ChatController extends ChatInit implements IChatMethod {
  /** 聊天事件定义 */
  private ChatEventDefine chatEventDefine;

  private ChatView chatView;

  public ChatController(IChatEvent chatEvent) {
    super(chatEvent);
  }

  @Override
  public void initView() {
    chatView = new ChatView(this, chatEvent);
  }

  @Override
  public void initEventDefine() {
    chatEventDefine = new ChatEventDefine(this,chatEvent,this);
  }

  @Override
  public void doShow() {
    super.show();
  }

  @Override
  public void setUserInfo(String userId, String userNickName, String userHead) {
    super.userId = userId;
    super.userNickName = userNickName;
    super.userHead = userHead;
    Button button = $("bar_portrait", Button.class);
    button.setStyle(String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", userHead));
  }

  @Override
  public void addTalkBox(
      int talkIdx,
      Integer talkType,
      String talkId,
      String talkName,
      String talkHead,
      String talkSketch,
      Date talkDate,
      Boolean selected) {
    // 获取对话栏列表，填充到对话框
    ListView<Pane> talkList = $("talkList", ListView.class);

    // 判断此对象是否填充过，避免重复填充。如果已经填充过根据入参即可选中
    ElementTalk elementTalk = CacheUtil.talkMap.get(talkId);
    if (null != elementTalk) {
      Node talkNode = talkList.lookup("#" + Ids.ElementTalkId.createTalkPaneId(talkId));
      if (null == talkNode) {
        talkList.getItems().add(talkIdx, elementTalk.pane());
      }
      if (selected) {
        // 设置选中
        talkList.getSelectionModel().select(elementTalk.pane());
      }
    }
    // 对于没有的对话框对象，则进行初始化操作，最后填充到对话框

    // 初始化对话框元素
    ElementTalk talkElement =
        new ElementTalk(talkId, talkType, talkName, talkHead, talkSketch, talkDate);
    CacheUtil.talkMap.put(talkId, talkElement);
    // 填充到对话框
    ObservableList<Pane> items = talkList.getItems();
    Pane talkElementPane = talkElement.pane();

    // 对话框位置
    if (talkIdx >= 0) {
      items.add(talkIdx, talkElementPane); // 添加到第一个位置
    } else {
      items.add(talkElementPane); // 顺序添加
    }

    if (selected) {
      talkList.getSelectionModel().select(talkElementPane);
    }

    // 对话框元素点击事件
    talkElementPane.setOnMousePressed(
        event -> {
          // 填充消息栏
          fillInfoBox(talkElement, talkName);
          // 清除消息提醒
          Label msgRemind = talkElement.msgRemind();
          msgRemind.setUserData(new RemindCount(0));
          msgRemind.setVisible(false);
        });

    // 鼠标事件[移入/移出]，删除按钮的显示和隐藏
    talkElementPane.setOnMouseEntered(
        event -> {
          talkElement.delete().setVisible(true);
        });
    talkElementPane.setOnMouseExited(
        event -> {
          talkElement.delete().setVisible(false);
        });

    // 点击删除按钮时，从对话框中删除
    talkElement
        .delete()
        .setOnMouseClicked(
            event -> {
              System.out.println("删除对话框：" + talkName);
              talkList.getItems().remove(talkElementPane);
              talkElement.clearMsgSketch();
            });
  }

  @Override
  public void addTalkMsgUserLeft(
      String talkId,
      String msg,
      Date msgData,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind) {
    // 对话框中的根据 talkId 找打对应的对话元素
    ElementTalk talkElement = CacheUtil.talkMap.get(talkId);
    // 对话框下的消息框[初始化，未装载]
    ListView<Pane> listView = talkElement.infoBoxList();

    TalkData talkUserData = (TalkData) listView.getUserData();
    Pane left =
        new ElementInfoBox().left(talkUserData.getTalkName(), talkUserData.getTalkHead(), msg);

    // 消息填充
    listView.getItems().add(left);
    // 滚动条
    listView.scrollTo(left);
    // 更新对话框信息概要
    talkElement.fillMsgSketch(msg, msgData);

    // 设置位置&选中
    chatView.updateTalkListIdxAndSelected(
        0, talkElement.pane(), talkElement.msgRemind(), idxFirst, selected, isRemind);
    // 填充对话框聊天窗口
    fillInfoBox(talkElement, talkUserData.getTalkName());
  }

  /**
   * 填充对话框消息内容
   * <p> 点击任何一个对话框，都会把对话框绑定的聊天框填充到右侧。也就是ID：info_pane_box
   * @param talkElement 对话框元素
   * @param talkName 对话名称
   */
  private void fillInfoBox(ElementTalk talkElement, String talkName) {
    String talkId = talkElement.pane().getUserData().toString();

    // 填充对话列表
    Pane info_pane_box = $("info_pane_box", Pane.class);
    String boxUserId = (String) info_pane_box.getUserData();
    // 判断是否已经填充[talkId]，当前已填充则返回
    if (talkId.equals(boxUserId)) return;

    ListView<Pane> listView = talkElement.infoBoxList();
    info_pane_box.setUserData(talkId);
    info_pane_box.getChildren().clear(); // 需要将原有的聊天框体清空，但是不会清空聊天记录。
    info_pane_box.getChildren().add(listView);
    // 对话框名称
    Label info_name = $("info_name", Label.class);
    info_name.setText(talkName);
  }

  @Override
  public void addTalkMsgGroupLeft(
      String talkId,
      String userId,
      String userNickName,
      String userHead,
      String msg,
      Date msgDate,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind) {
    // 自己的消息抛弃
    if (super.userId.equals(userId)) return;
    ElementTalk talkElement = CacheUtil.talkMap.get(talkId);
    if (null == talkElement) {
      GroupsData groupsData = (GroupsData) $(Ids.ElementTalkId.createFriendGroupId(talkId), Pane.class).getUserData();
      if (null == groupsData) return;
      addTalkBox(0, 1, talkId, groupsData.getGroupName(), groupsData.getGroupHead(), userNickName + "：" + msg, msgDate, false);
      talkElement = CacheUtil.talkMap.get(talkId);
      // 事件通知(开启与群组发送消息)
      System.out.println("事件通知(开启与群组发送消息)");
    }
    ListView<Pane> listView = talkElement.infoBoxList();
    TalkData talkData = (TalkData) listView.getUserData();
    Pane left = new ElementInfoBox().left(userNickName, userHead, msg);
    // 消息填充
    listView.getItems().add(left);
    // 滚动条
    listView.scrollTo(left);
    talkElement.fillMsgSketch(userNickName + "：" + msg, msgDate);
    // 设置位置&选中
    chatView.updateTalkListIdxAndSelected(1, talkElement.pane(), talkElement.msgRemind(), idxFirst, selected, isRemind);
    // 填充对话框聊天窗口
    fillInfoBox(talkElement, talkData.getTalkName());

  }

  @Override
  public void addTalkMsgRight(
      String talkId,
      String msg,
      Date msgData,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind) {
    // 对话框
    ElementTalk talkElement = CacheUtil.talkMap.get(talkId);
    // 初始化填充消息对话框
    ListView<Pane> listView = talkElement.infoBoxList();
    // 右侧消息个人
    Pane right = new ElementInfoBox().right(userNickName, userHead, msg);
    // 消息填充
    listView.getItems().add(right);
    // 滚动条
    listView.scrollTo(right);
    talkElement.fillMsgSketch(msg, msgData);
    // 设置位置&选中
    chatView.updateTalkListIdxAndSelected(0, talkElement.pane(), talkElement.msgRemind(), idxFirst, selected, isRemind);
  }
}

package com.doublew2w.naive.chat.ui.view.chat;

import com.doublew2w.naive.chat.ui.util.CacheUtil;
import com.doublew2w.naive.chat.ui.util.Ids;
import com.doublew2w.naive.chat.ui.view.chat.element.group_bar_chat.ElementTalk;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.scene.Node;
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

  @Override
  public void initView() {}

  @Override
  public void initEventDefine() {
    chatEventDefine = new ChatEventDefine(this);
  }

  @Override
  public void doShow() {
    super.show();
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
          System.out.println("点击对话框：" + talkName);
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
}

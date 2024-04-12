package com.doublew2w.naive.chat.ui.view.chat.element.group_bar_chat;

import com.doublew2w.naive.chat.ui.util.DateUtil;
import com.doublew2w.naive.chat.ui.util.Ids;
import com.doublew2w.naive.chat.ui.view.chat.data.RemindCount;
import com.doublew2w.naive.chat.ui.view.chat.data.TalkBoxData;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * @author: DoubleW2w
 * @description: 对话框元素封装
 * @date: 2024/4/12 21:23
 * @project: IM-Netty-NaiveChat
 */
public class ElementTalk {
  /** 对话面板(与好友对话、与群组对话) */
  private Pane pane;

  /** 头像区域 */
  private Label head;

  /** 昵称区域 */
  private Label nikeName;

  /** 昵称区域 */
  private Label msgSketch;

  /** 信息时间 */
  private Label msgData;

  /** 消息提醒 */
  private Label msgRemind;

  /** 删除对话框按钮 */
  private Button delete;

  /**
   * 初始化整体窗体，
   *
   * <p>并
   */
  public ElementTalk(
      String talkId,
      Integer talkType,
      String talkName,
      String talkHead,
      String talkSketch,
      Date talkDate) {
    // 初始化整体窗体，并设置id，整个id是我们使用工具类生成，以为了保证唯一性
    pane = new Pane();
    pane.setId(Ids.ElementTalkId.createTalkPaneId(talkId));
    // 设置对话框数据
    pane.setUserData(new TalkBoxData(talkId, talkType, talkName, talkHead));
    // 设置框体大小和设计CSS属性
    pane.setPrefSize(270, 80);
    pane.getStyleClass().add("talkElement");
    ObservableList<Node> children = pane.getChildren();

    // 头像区域
    head = new Label();
    head.setPrefSize(50, 50);
    head.setLayoutX(15);
    head.setLayoutY(15);
    head.getStyleClass().add("element_head");
    head.setStyle(
        String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", talkHead));
    children.add(head);

    // 昵称区域
    nikeName = new Label();
    nikeName.setPrefSize(140, 25);
    nikeName.setLayoutX(80);
    nikeName.setLayoutY(15);
    nikeName.setText(talkName);
    nikeName.getStyleClass().add("element_nikeName");
    children.add(nikeName);

    // 信息简述
    msgSketch = new Label();
    msgSketch.setId(Ids.ElementTalkId.createMsgSketchId(talkId));
    msgSketch.setPrefSize(200, 25);
    msgSketch.setLayoutX(80);
    msgSketch.setLayoutY(40);
    msgSketch.getStyleClass().add("element_msgSketch");
    children.add(msgSketch);

    // 信息时间
    msgData = new Label();
    msgData.setId(Ids.ElementTalkId.createMsgDataId(talkId));
    msgData.setPrefSize(60, 25);
    msgData.setLayoutX(220);
    msgData.setLayoutY(15);
    msgData.getStyleClass().add("element_msgData");
    children.add(msgData);
    // 填充；信息简述 & 信息时间
    fillMsgSketch(talkSketch, talkDate);

    // 消息提醒
    msgRemind = new Label();
    msgRemind.setPrefSize(15, 15);
    msgRemind.setLayoutX(60);
    msgRemind.setLayoutY(5);
    msgRemind.setUserData(new RemindCount());
    msgRemind.setText("");
    msgRemind.setVisible(false);
    msgRemind.getStyleClass().add("element_msgRemind");
    children.add(msgRemind);

    // 删除对话框按钮
    delete = new Button();
    delete.setVisible(false);
    delete.setPrefSize(4, 4);
    delete.setLayoutY(26);
    delete.setLayoutX(-8);
    delete.getStyleClass().add("element_delete");
    children.add(delete);
  }

  public Pane pane() {
    return pane;
  }

  public Button delete() {
    return delete;
  }

  /**
   * 统一更新方法
   *
   * @param talkSketch 信息概要
   * @param talkDate 聊天事件
   */
  public void fillMsgSketch(String talkSketch, Date talkDate) {
    if (null != talkSketch) {
      if (talkSketch.length() > 30) talkSketch = talkSketch.substring(0, 30);
      msgSketch.setText(talkSketch);
    }
    if (null == talkDate) talkDate = new Date();
    // 格式化信息
    String talkSimpleDate = DateUtil.simpleDate(talkDate);
    msgData.setText(talkSimpleDate);
  }

  public void clearMsgSketch() {
    msgSketch.setText("");
  }

  public Label msgRemind() {
    return msgRemind;
  }
}

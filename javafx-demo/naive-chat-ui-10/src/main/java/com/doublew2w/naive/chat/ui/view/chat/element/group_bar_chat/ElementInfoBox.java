package com.doublew2w.naive.chat.ui.view.chat.element.group_bar_chat;

import com.doublew2w.naive.chat.ui.util.AutoSizeTool;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

/**
 * 消息对话的内容的承载
 *
 * @author: DoubleW2w
 * @description: 对话聊天框信息封装
 * @date: 2024/4/12 23:37
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ElementInfoBox {
  /** 所属布局 */
  private Pane pane;

  /** 头像 */
  private Pane head;

  /** 昵称区 */
  private Label nikeName;

  /** 内容箭头 */
  private Label infoContentArrow;

  /** 内容 */
  private TextArea infoContent;

  /**
   * 左侧消息：好友
   *
   * @param userNickName 好友昵称
   * @param userHead 好友头像
   * @param msg 消息
   * @return 左侧
   */
  public Pane left(String userNickName, String userHead, String msg) {
    double autoHeight = AutoSizeTool.getHeight(msg);
    double autoWidth = AutoSizeTool.getWidth(msg);
    // 左侧的布局
    pane = new Pane();
    pane.setPrefSize(500, 50 + autoHeight);
    pane.getStyleClass().add("infoBoxElement");
    ObservableList<Node> children = pane.getChildren();

    // 头像
    head = new Pane();
    head.setPrefSize(50, 50);
    head.setLayoutX(15);
    head.setLayoutY(15);
    head.getStyleClass().add("box_head");
    head.setStyle(
        String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", userHead));
    children.add(head);

    // 昵称
    nikeName = new Label();
    nikeName.setPrefSize(450, 20);
    nikeName.setLayoutX(75);
    nikeName.setLayoutY(5);
    nikeName.setText(userNickName); // "小傅哥 | bugstack.cn"
    nikeName.getStyleClass().add("box_nikeName");
    children.add(nikeName);

    // 箭头
    infoContentArrow = new Label();
    infoContentArrow.setPrefSize(5, 20);
    infoContentArrow.setLayoutX(75);
    infoContentArrow.setLayoutY(30);
    infoContentArrow.getStyleClass().add("box_infoContent_arrow");
    children.add(infoContentArrow);

    // 内容
    infoContent = new TextArea();
    infoContent.setPrefWidth(autoWidth);
    infoContent.setPrefHeight(autoHeight);
    infoContent.setLayoutX(80);
    infoContent.setLayoutY(30);
    infoContent.setWrapText(true);
    infoContent.setEditable(false);
    infoContent.setText(msg);
    infoContent.getStyleClass().add("box_infoContent_left");
    children.add(infoContent);

    return pane;
  }

  /**
   * 右侧消息：个人
   *
   * @param userNickName 昵称
   * @param userHead 头像
   * @param msg 消息
   * @return 右侧
   */
  public Pane right(String userNickName, String userHead, String msg) {

    double autoHeight = AutoSizeTool.getHeight(msg);
    double autoWidth = AutoSizeTool.getWidth(msg);

    pane = new Pane();
    pane.setPrefSize(500, 50 + autoHeight);
    pane.setLayoutX(853);
    pane.setLayoutY(0);
    pane.getStyleClass().add("infoBoxElement");
    ObservableList<Node> children = pane.getChildren();

    // 头像
    head = new Pane();
    head.setPrefSize(50, 50);
    head.setLayoutX(770);
    head.setLayoutY(15);
    head.getStyleClass().add("box_head");
    head.setStyle(
        String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", userHead));
    children.add(head);

    // 箭头
    infoContentArrow = new Label();
    infoContentArrow.setPrefSize(5, 20);
    infoContentArrow.setLayoutX(755);
    infoContentArrow.setLayoutY(15);
    infoContentArrow.getStyleClass().add("box_infoContent_arrow");
    children.add(infoContentArrow);

    // 内容
    infoContent = new TextArea();
    infoContent.setPrefWidth(autoWidth);
    infoContent.setPrefHeight(autoHeight);
    infoContent.setLayoutX(755 - autoWidth);
    infoContent.setLayoutY(15);
    infoContent.setWrapText(true);
    infoContent.setEditable(false);
    infoContent.setText(msg);
    infoContent.getStyleClass().add("box_infoContent_right");
    children.add(infoContent);

    return pane;
  }
}

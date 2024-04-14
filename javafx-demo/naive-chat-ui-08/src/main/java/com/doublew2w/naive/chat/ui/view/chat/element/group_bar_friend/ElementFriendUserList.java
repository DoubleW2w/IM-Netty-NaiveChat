package com.doublew2w.naive.chat.ui.view.chat.element.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * 装载好友元素的，并最终将好友列表填充到整个面板中
 *
 * @author: DoubleW2w
 * @description: 好友列表
 * @date: 2024/4/14 1:06
 * @project: IM-Netty-NaiveChat
 */
public class ElementFriendUserList {
  /** 所属面板 */
  private Pane pane;

  /** 好友列表 */
  private ListView<Pane> userListView;

  public ElementFriendUserList() {
    pane = new Pane();
    pane.setId("friendUserList");
    pane.setPrefWidth(314);
    pane.setPrefHeight(0); // 自动计算；userListView.setPrefHeight(70 * items.size() + 10);
    pane.setLayoutX(-10);
    pane.getStyleClass().add("elementFriendUserList");
    ObservableList<Node> children = pane.getChildren();

    userListView = new ListView<>();
    userListView.setId("userListView");
    userListView.setPrefWidth(314);
    userListView.setPrefHeight(0); // 自动计算；userListView.setPrefHeight(70 * items.size() + 10);
    userListView.setLayoutX(-10);
    userListView.getStyleClass().add("elementFriendUser_listView");
    children.add(userListView);
  }

  public Pane pane() {
    return pane;
  }
}

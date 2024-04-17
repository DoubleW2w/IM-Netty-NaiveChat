package com.doublew2w.naive.chat.ui.view.chat.element.group_bar_friend;

import com.doublew2w.naive.chat.ui.util.Ids;
import com.doublew2w.naive.chat.ui.view.chat.data.GroupsData;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 19:44
 * @project: IM-Netty-NaiveChat
 */
public class ElementFriendGroup {

  private Pane groupPane;

  public ElementFriendGroup(String groupId, String groupName, String groupHead) {
    // 群组底板(存储群ID)
    groupPane = new Pane();
    groupPane.setId(Ids.ElementTalkId.createFriendGroupId(groupId));
    groupPane.setUserData(new GroupsData(groupId, groupName, groupHead));
    groupPane.setPrefWidth(250);
    groupPane.setPrefHeight(70);
    groupPane.getStyleClass().add("elementFriendGroup");
    ObservableList<Node> children = groupPane.getChildren();
    // 头像区域
    Label groupHeadLabel = new Label();
    groupHeadLabel.setPrefSize(50, 50);
    groupHeadLabel.setLayoutX(15);
    groupHeadLabel.setLayoutY(10);
    groupHeadLabel.getStyleClass().add("elementFriendGroup_head");
    groupHeadLabel.setStyle(
        String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", groupHead));
    children.add(groupHeadLabel);
    // 名称区域
    Label groupNameLabel = new Label();
    groupNameLabel.setPrefSize(200, 40);
    groupNameLabel.setLayoutX(80);
    groupNameLabel.setLayoutY(15);
    groupNameLabel.setText(groupName);
    groupNameLabel.getStyleClass().add("elementFriendGroup_name");
    children.add(groupNameLabel);
  }

  public Pane pane() {
    return groupPane;
  }
}

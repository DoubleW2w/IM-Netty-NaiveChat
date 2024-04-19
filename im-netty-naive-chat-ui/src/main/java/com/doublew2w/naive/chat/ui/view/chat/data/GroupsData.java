package com.doublew2w.naive.chat.ui.view.chat.data;

import lombok.Getter;
import lombok.Setter;

/**
 * 群组数据(ElementFriendGroup)
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:44
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class GroupsData {
  /** 群组ID */
  private String groupId;

  /** 群组名称 */
  private String groupName;

  /** 群组头像 */
  private String groupHead;

  public GroupsData() {}

  public GroupsData(String groupId, String groupName, String groupHead) {
    this.groupId = groupId;
    this.groupName = groupName;
    this.groupHead = groupHead;
  }
}

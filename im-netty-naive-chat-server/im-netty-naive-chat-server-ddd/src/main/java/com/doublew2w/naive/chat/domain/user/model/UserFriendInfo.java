package com.doublew2w.naive.chat.domain.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 14:13
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserFriendInfo {
  /** 好友ID */
  private String friendId;

  /** 好友名称 */
  private String friendName;

  /** 好友头像 */
  private String friendHead;
}

package com.doublew2w.naive.chat.protocol.login.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/16 23:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserFriendDto {
  /** 好友ID */
  private String friendId;

  /** 好友名称 */
  private String friendName;

  /** 好友头像 */
  private String friendHead;
}

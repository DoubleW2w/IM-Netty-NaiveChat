package com.doublew2w.naive.chat.protocol.friend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserDto {

  private String userId; // 用户ID
  private String userNickName; // 用户昵称
  private String userHead; // 用户头像
  private Integer status; // 状态；0添加、1[保留]、2已添加

  public UserDto() {}

  public UserDto(String userId, String userNickName, String userHead) {
    this.userId = userId;
    this.userNickName = userNickName;
    this.userHead = userHead;
  }
}

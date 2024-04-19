package com.doublew2w.naive.chat.protocol.friend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 好友相关请求传输类
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class SearchUserDto {
  /** 用户ID */
  private String userId;

  /** 用户昵称 */
  private String userNickName;

  /** 用户头像 */
  private String userHead;

  /** 状态；0添加、1[保留]、2已添加 */
  private Integer status;

  public SearchUserDto() {}

  public SearchUserDto(String userId, String userNickName, String userHead) {
    this.userId = userId;
    this.userNickName = userNickName;
    this.userHead = userHead;
  }
}

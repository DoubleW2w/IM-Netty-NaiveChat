package com.doublew2w.naive.chat.domain.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:42
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class LuckUserInfo {
  private String userId;       //用户ID
  private String userNickName; //用户昵称
  private String userHead;     //用户头像
  private Integer status;      // 状态；0添加、1[保留]、2已添加

  public LuckUserInfo() {
  }

  public LuckUserInfo(String userId, String userNickName, String userHead) {
    this.userId = userId;
    this.userNickName = userNickName;
    this.userHead = userHead;
  }

  public LuckUserInfo(String userId, String userNickName, String userHead, Integer status) {
    this.userId = userId;
    this.userNickName = userNickName;
    this.userHead = userHead;
    this.status = status;
  }

}

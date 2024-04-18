package com.doublew2w.naive.chat.ddd.domain.inet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:07
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
@NoArgsConstructor
public class ChannelUserInfo {
  private String userId;       //用户ID
  private String userNickName; //用户昵称
  private String userHead;     //用户头像
  private boolean status;      //状态[true在线、false不在线]

  public ChannelUserInfo(String userId, String userNickName, String userHead, boolean status) {
    this.userId = userId;
    this.userNickName = userNickName;
    this.userHead = userHead;
    this.status = status;
  }
}

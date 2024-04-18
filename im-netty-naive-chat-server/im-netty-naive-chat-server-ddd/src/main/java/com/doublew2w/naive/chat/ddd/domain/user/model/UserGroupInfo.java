package com.doublew2w.naive.chat.ddd.domain.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 23:42
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserGroupInfo {
  private String userId;       //用户ID
  private String userNickName; //用户昵称
  private String userHead;     //用户头像
}

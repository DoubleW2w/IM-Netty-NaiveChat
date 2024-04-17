package com.doublew2w.naive.chat.domain.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 9:23
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserInfo {
  /** 用户ID */
  private String userId;

  /** 用户昵称 */
  private String userNickName;

  /** 用户头像 */
  private String userHead;
}

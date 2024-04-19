package com.doublew2w.naive.chat.ddd.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户好友
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
@NoArgsConstructor
public class UserFriend {
  /** 自增ID */
  private Long id;

  /** 用户ID */
  private String userId;

  /** 好友用户ID */
  private String userFriendId;

  /** 创建时间 */
  private Date createTime;

  /** 更新时间 */
  private Date updateTime;

  public UserFriend(String userId, String userFriendId) {
    this.userId = userId;
    this.userFriendId = userFriendId;
  }
}

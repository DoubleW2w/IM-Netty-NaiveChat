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
public class GroupsDto {
  /** 群组ID */
  private String groupId;

  /** 群组名称 */
  private String groupName;

  /** 群组头像 */
  private String groupHead;
}

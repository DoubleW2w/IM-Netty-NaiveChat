package com.doublew2w.naive.chat.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户群组
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserGroup {

  private Long id; // 自增ID
  private String userId; // 用户ID
  private String groupId; // 群组ID
  private Date createTime; // 创建时间
  private Date updateTime; // 更新时间


}

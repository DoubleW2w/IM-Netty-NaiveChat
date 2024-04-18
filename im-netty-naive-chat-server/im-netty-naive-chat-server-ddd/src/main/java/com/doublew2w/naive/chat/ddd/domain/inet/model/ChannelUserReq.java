package com.doublew2w.naive.chat.ddd.domain.inet.model;

import com.doublew2w.naive.chat.ddd.infrastructure.common.PageReq;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:06
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ChannelUserReq extends PageReq {
  private String userId;
  private String userNickName;
}

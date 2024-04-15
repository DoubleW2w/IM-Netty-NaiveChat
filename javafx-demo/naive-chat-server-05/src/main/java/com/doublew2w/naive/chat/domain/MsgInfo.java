package com.doublew2w.naive.chat.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 22:06
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class MsgInfo {
  private String channelId;
  private String msgContent;

  public MsgInfo() {
  }

  public MsgInfo(String channelId, String msgContent) {
    this.channelId = channelId;
    this.msgContent = msgContent;
  }
}

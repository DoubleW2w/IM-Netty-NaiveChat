package com.doublew2w.naive.chat.ui.view.chat.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/12 21:23
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class TalkBoxData {
  /** 对话Id */
  private String talkId;

  /** 对话类型 */
  private Integer talkType;

  /** 对话名称 */
  private String talkName;

  /** 对话头像 */
  private String talkHead;

  public TalkBoxData() {}

  public TalkBoxData(String talkId, Integer talkType, String talkName, String talkHead) {
    this.talkId = talkId;
    this.talkType = talkType;
    this.talkName = talkName;
    this.talkHead = talkHead;
  }
}

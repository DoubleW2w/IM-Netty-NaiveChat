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
public class TalkData {
  /** 对话名称 */
  private String talkName;

  /** 对话头像 */
  private String talkHead;

  public TalkData() {}

  public TalkData(String talkName, String talkHead) {
    this.talkName = talkName;
    this.talkHead = talkHead;
  }
}

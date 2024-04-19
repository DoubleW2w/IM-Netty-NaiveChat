package com.doublew2w.naive.chat.ui.view.chat.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 19:44
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
@NoArgsConstructor
public class TalkBoxData {

  private String talkId; // 对话Id
  private Integer talkType; // 对话类型
  private String talkName; // 对话名称
  private String talkHead; // 对话头像

  public TalkBoxData(String talkId, Integer talkType, String talkName, String talkHead) {
    this.talkId = talkId;
    this.talkType = talkType;
    this.talkName = talkName;
    this.talkHead = talkHead;
  }
}

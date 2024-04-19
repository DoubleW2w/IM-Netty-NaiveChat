package com.doublew2w.naive.chat.ui.view.chat.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 对话框用户数据
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:44
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
@NoArgsConstructor
public class TalkData {

  private String talkName;
  private String talkHead;

  public TalkData(String talkName, String talkHead) {
    this.talkName = talkName;
    this.talkHead = talkHead;
  }
}

package com.doublew2w.naive.chat.ui.view.chat.data;

/**
 * 对话框用户数据
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 19:44
 * @project: IM-Netty-NaiveChat
 */
public class TalkData {

  private String talkName;
  private String talkHead;

  public TalkData() {}

  public TalkData(String talkName, String talkHead) {
    this.talkName = talkName;
    this.talkHead = talkHead;
  }

  public String getTalkName() {
    return talkName;
  }

  public void setTalkName(String talkName) {
    this.talkName = talkName;
  }

  public String getTalkHead() {
    return talkHead;
  }

  public void setTalkHead(String talkHead) {
    this.talkHead = talkHead;
  }
}

package com.doublew2w.naive.chat.ui.view.chat;

/**
 * 聊天窗口展示类
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/11 0:13
 * @project: IM-Netty-NaiveChat
 */
public class ChatView {
  private ChatInit chatInit;
  private IChatEvent chatEvent;

  public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
    this.chatInit = chatInit;
    this.chatEvent = chatEvent;
  }
}

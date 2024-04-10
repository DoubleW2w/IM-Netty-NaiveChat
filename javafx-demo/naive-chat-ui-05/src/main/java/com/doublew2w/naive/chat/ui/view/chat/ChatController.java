package com.doublew2w.naive.chat.ui.view.chat;

/**
 * 聊天的控制器类
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 23:42
 * @project: IM-Netty-NaiveChat
 */
public class ChatController extends ChatInit implements IChatMethod {
  /** 聊天事件定义 */
  private ChatEventDefine chatEventDefine;

  @Override
  public void initView() {}

  @Override
  public void initEventDefine() {
    chatEventDefine = new ChatEventDefine(this);
  }

  @Override
  public void doShow() {
    super.show();
  }
}

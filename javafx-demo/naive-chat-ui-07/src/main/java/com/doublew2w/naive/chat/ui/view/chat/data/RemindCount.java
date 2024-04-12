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
public class RemindCount {
  /** 消息提醒条数 */
  private int count = 0;

  public RemindCount() {}

  public RemindCount(int count) {
    this.count = count;
  }
}

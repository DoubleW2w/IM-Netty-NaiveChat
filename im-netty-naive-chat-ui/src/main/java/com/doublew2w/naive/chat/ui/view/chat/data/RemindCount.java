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
public class RemindCount {

  private int count = 0; // 消息提醒条数

  public RemindCount(int count) {
    this.count = count;
  }
}

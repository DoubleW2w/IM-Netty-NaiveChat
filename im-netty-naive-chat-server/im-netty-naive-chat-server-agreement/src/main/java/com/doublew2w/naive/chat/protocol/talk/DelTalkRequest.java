package com.doublew2w.naive.chat.protocol.talk;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * 删除对话框请求
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class DelTalkRequest extends Packet {

  private String userId; // 用户ID
  private String talkId; // 对话框ID

  public DelTalkRequest() {}

  public DelTalkRequest(String userId, String talkId) {
    this.userId = userId;
    this.talkId = talkId;
  }

  @Override
  public Byte getCommand() {
    return Command.DelTalkRequest;
  }
}

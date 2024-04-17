package com.doublew2w.naive.chat.protocol.talk;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * 对话通知请求
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class TalkNoticeRequest extends Packet {

  private String userId; // 用户ID
  private String friendUserId; // 好友ID
  private Integer talkType; // 对话框类型[0好友、1群组]

  public TalkNoticeRequest() {}

  public TalkNoticeRequest(String userId, String friendUserId, Integer talkType) {
    this.userId = userId;
    this.friendUserId = friendUserId;
    this.talkType = talkType;
  }

  @Override
  public Byte getCommand() {
    return Command.TalkNoticeRequest;
  }
}

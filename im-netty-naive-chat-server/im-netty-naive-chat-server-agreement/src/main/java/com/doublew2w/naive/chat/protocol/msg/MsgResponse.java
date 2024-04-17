package com.doublew2w.naive.chat.protocol.msg;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class MsgResponse extends Packet {

  private String friendId; // 好友ID[对方]
  private String msgText; // 传输消息内容
  private Integer msgType; // 消息类型；0文字消息、1固定表情
  private Date msgDate; // 消息时间

  public MsgResponse() {}

  public MsgResponse(String friendId, String msgText, Integer msgType, Date msgDate) {
    this.friendId = friendId;
    this.msgText = msgText;
    this.msgType = msgType;
    this.msgDate = msgDate;
  }

  @Override
  public Byte getCommand() {
    return Command.MsgResponse;
  }
}

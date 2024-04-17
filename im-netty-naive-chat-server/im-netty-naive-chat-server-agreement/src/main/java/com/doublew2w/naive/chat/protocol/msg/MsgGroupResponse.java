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
public class MsgGroupResponse extends Packet {

  private String talkId; // 对话框ID
  private String userId; // 群员用户ID
  private String userNickName; // 群员用户昵称
  private String userHead; // 群员用户头像
  private String msg; // 群员用户发送消息内容
  private Integer msgType; // 消息类型；0文字消息、1固定表情
  private Date msgDate; // 群员用户发送消息时间

  public MsgGroupResponse() {}

  @Override
  public Byte getCommand() {
    return Command.MsgGroupResponse;
  }
}

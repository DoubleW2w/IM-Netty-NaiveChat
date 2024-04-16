package com.doublew2w.naive.chat.protocol.login;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/16 23:33
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ReconnectRequest extends Packet {
  /** 用户Id */
  private String userId;

  @Override
  public Byte getCommand() {
    return Command.ReconnectRequest;
  }
}

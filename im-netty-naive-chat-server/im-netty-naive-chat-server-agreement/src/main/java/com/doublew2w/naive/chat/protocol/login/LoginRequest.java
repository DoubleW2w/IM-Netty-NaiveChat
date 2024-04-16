package com.doublew2w.naive.chat.protocol.login;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录请求类
 *
 * @author: DoubleW2w
 * @date: 2024/4/16 23:03
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class LoginRequest extends Packet {
  /** 用户Id */
  private String userId;

  /** 用户密码 */
  private String userPassword;

  @Override
  public Byte getCommand() {
    return Command.LoginRequest;
  }
}

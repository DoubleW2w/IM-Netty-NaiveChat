package com.doublew2w.naive.chat.protocol;

/**
 * 传输对象的指令码
 *
 * @author: DoubleW2w
 * @description: 标识指令码
 * @date: 2024/4/16 16:51
 * @project: IM-Netty-NaiveChat
 */
public interface Command {

  Byte LoginRequest = 1;
  Byte LoginResponse = 2;
  Byte ReconnectRequest = 3;
}

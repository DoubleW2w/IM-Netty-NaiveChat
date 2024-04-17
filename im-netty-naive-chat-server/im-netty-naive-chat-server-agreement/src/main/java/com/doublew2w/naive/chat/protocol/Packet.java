package com.doublew2w.naive.chat.protocol;

import com.doublew2w.naive.chat.protocol.login.LoginRequest;
import com.doublew2w.naive.chat.protocol.login.LoginResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: DoubleW2w
 * @description: 数据包
 * @date: 2024/4/16 16:51
 * @project: IM-Netty-NaiveChat
 */
public abstract class Packet {
  private static final Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();

  static {
    packetType.put(Command.LoginRequest, LoginRequest.class);
    packetType.put(Command.LoginResponse, LoginResponse.class);
  }

  public static Class<? extends Packet> get(Byte command) {
    return packetType.get(command);
  }

  /**
   * 获取协议指令
   *
   * @return 返回指令值
   */
  public abstract Byte getCommand();
}

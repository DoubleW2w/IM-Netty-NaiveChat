package com.doublew2w.naive.chat.protocol;

import com.doublew2w.naive.chat.protocol.friend.AddFriendRequest;
import com.doublew2w.naive.chat.protocol.friend.AddFriendResponse;
import com.doublew2w.naive.chat.protocol.friend.SearchFriendRequest;
import com.doublew2w.naive.chat.protocol.friend.SearchFriendResponse;
import com.doublew2w.naive.chat.protocol.login.LoginRequest;
import com.doublew2w.naive.chat.protocol.login.LoginResponse;
import com.doublew2w.naive.chat.protocol.msg.MsgGroupRequest;
import com.doublew2w.naive.chat.protocol.msg.MsgRequest;
import com.doublew2w.naive.chat.protocol.msg.MsgResponse;
import com.doublew2w.naive.chat.protocol.talk.DelTalkRequest;
import com.doublew2w.naive.chat.protocol.talk.TalkNoticeRequest;
import com.doublew2w.naive.chat.protocol.talk.TalkNoticeResponse;
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
    // 登录相关
    packetType.put(Command.LoginRequest, LoginRequest.class);
    packetType.put(Command.LoginResponse, LoginResponse.class);
    // 好友相关
    packetType.put(Command.AddFriendRequest, AddFriendRequest.class);
    packetType.put(Command.AddFriendResponse, AddFriendResponse.class);
    packetType.put(Command.SearchFriendRequest, SearchFriendRequest.class);
    packetType.put(Command.SearchFriendResponse, SearchFriendResponse.class);
    // 群组相关
    packetType.put(Command.MsgRequest, MsgRequest.class);
    packetType.put(Command.MsgGroupRequest, MsgGroupRequest.class);
    packetType.put(Command.MsgResponse, MsgResponse.class);
    packetType.put(Command.MsgGroupResponse, MsgResponse.class);
    // 聊天相关
    packetType.put(Command.DelTalkRequest, DelTalkRequest.class);
    packetType.put(Command.TalkNoticeRequest, TalkNoticeRequest.class);
    packetType.put(Command.TalkNoticeResponse, TalkNoticeResponse.class);
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

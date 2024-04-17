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

  Byte MsgRequest = 3;
  Byte MsgResponse = 4;

  Byte TalkNoticeRequest = 5;
  Byte TalkNoticeResponse = 6;

  Byte SearchFriendRequest = 7;
  Byte SearchFriendResponse = 8;

  Byte AddFriendRequest = 9;
  Byte AddFriendResponse = 10;

  Byte DelTalkRequest = 11;

  Byte MsgGroupRequest = 12;
  Byte MsgGroupResponse = 13;

  Byte ReconnectRequest = 14;
}

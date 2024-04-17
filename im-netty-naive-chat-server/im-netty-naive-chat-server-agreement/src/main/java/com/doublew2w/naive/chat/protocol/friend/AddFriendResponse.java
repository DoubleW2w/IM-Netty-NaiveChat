package com.doublew2w.naive.chat.protocol.friend;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * 添加好友响应
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class AddFriendResponse extends Packet {

  private String friendId;
  private String friendNickName;
  private String friendHead;

  public AddFriendResponse() {}

  public AddFriendResponse(String friendId, String friendNickName, String friendHead) {
    this.friendId = friendId;
    this.friendNickName = friendNickName;
    this.friendHead = friendHead;
  }

  @Override
  public Byte getCommand() {
    return Command.AddFriendResponse;
  }
}

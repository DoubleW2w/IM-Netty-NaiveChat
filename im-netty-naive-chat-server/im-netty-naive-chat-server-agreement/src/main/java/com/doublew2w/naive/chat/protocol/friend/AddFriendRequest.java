package com.doublew2w.naive.chat.protocol.friend;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * 添加好友请求
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class AddFriendRequest extends Packet {

  private String userId; // 用户ID[自己的ID]
  private String friendId; // 好友ID

  public AddFriendRequest() {}

  public AddFriendRequest(String userId, String friendId) {
    this.userId = userId;
    this.friendId = friendId;
  }

  @Override
  public Byte getCommand() {
    return Command.AddFriendRequest;
  }
}

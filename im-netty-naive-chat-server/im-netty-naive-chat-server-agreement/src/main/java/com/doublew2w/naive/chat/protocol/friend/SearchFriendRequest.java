package com.doublew2w.naive.chat.protocol.friend;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;

/**
 * 搜索好友请求
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class SearchFriendRequest extends Packet {

  private String userId; // 用户ID
  private String searchKey; // 搜索字段

  public SearchFriendRequest() {}

  public SearchFriendRequest(String userId, String searchKey) {
    this.userId = userId;
    this.searchKey = searchKey;
  }

  @Override
  public Byte getCommand() {
    return Command.SearchFriendRequest;
  }
}

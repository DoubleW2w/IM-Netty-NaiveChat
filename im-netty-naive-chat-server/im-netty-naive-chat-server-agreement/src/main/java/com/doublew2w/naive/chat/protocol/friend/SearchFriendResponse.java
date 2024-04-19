package com.doublew2w.naive.chat.protocol.friend;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import com.doublew2w.naive.chat.protocol.friend.dto.SearchUserDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 搜索好友应答
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class SearchFriendResponse extends Packet {

  private List<SearchUserDto> list;

  @Override
  public Byte getCommand() {
    return Command.SearchFriendResponse;
  }
}

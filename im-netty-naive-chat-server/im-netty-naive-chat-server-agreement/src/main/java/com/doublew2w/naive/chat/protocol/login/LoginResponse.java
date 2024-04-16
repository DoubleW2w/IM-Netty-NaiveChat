package com.doublew2w.naive.chat.protocol.login;

import com.doublew2w.naive.chat.protocol.Command;
import com.doublew2w.naive.chat.protocol.Packet;
import com.doublew2w.naive.chat.protocol.login.dto.ChatTalkDto;
import com.doublew2w.naive.chat.protocol.login.dto.GroupsDto;
import com.doublew2w.naive.chat.protocol.login.dto.UserFriendDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/16 23:05
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class LoginResponse extends Packet {
  /** 登录响应 */
  private boolean success;

  /** 用户Id */
  private String userId;

  /** 用户头像 */
  private String userHead;

  /** 用户昵称 */
  private String userNickName;

  /** 聊天对话框数据 */
  private List<ChatTalkDto> chatTalkList = new ArrayList<>();

  /** 群组列表 */
  private List<GroupsDto> groupsList = new ArrayList<>();

  /** 好友列表 */
  private List<UserFriendDto> userFriendList = new ArrayList<>();

  @Override
  public Byte getCommand() {
    return Command.LoginResponse;
  }
}

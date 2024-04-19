package com.doublew2w.naive.chat.ddd.socket.handler;

import com.doublew2w.naive.chat.ddd.application.UserService;
import com.doublew2w.naive.chat.ddd.infrastructure.util.SocketChannelUtil;
import com.doublew2w.naive.chat.ddd.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.login.ReconnectRequest;
import io.netty.channel.Channel;
import java.util.List;

/**
 * 重连处理
 *
 * @author: DoubleW2w
 * @date: 2024/4/19 17:08
 * @project: IM-Netty-NaiveChat
 */
public class ReconnectHandler extends MyBizHandler<ReconnectRequest> {

  public ReconnectHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, ReconnectRequest msg) {
    logger.info("客户端断线重连处理。userId：{}", msg.getUserId());
    // 添加用户Channel
    SocketChannelUtil.removeUserChannelByUserId(msg.getUserId());
    SocketChannelUtil.addChannel(msg.getUserId(), channel);
    // 添加群组Channel
    List<String> groupsIdList = userService.queryTalkBoxGroupsIdList(msg.getUserId());
    for (String groupsId : groupsIdList) {
      SocketChannelUtil.addChannelGroup(groupsId, channel);
    }
  }
}

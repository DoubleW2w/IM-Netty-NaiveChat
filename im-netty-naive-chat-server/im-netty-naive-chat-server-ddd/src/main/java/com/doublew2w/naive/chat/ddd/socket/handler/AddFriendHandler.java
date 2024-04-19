package com.doublew2w.naive.chat.ddd.socket.handler;

import com.doublew2w.naive.chat.ddd.application.UserService;
import com.doublew2w.naive.chat.ddd.domain.user.model.UserInfo;
import com.doublew2w.naive.chat.ddd.infrastructure.po.UserFriend;
import com.doublew2w.naive.chat.ddd.infrastructure.util.SocketChannelUtil;
import com.doublew2w.naive.chat.ddd.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.friend.AddFriendRequest;
import com.doublew2w.naive.chat.protocol.friend.AddFriendResponse;
import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.List;

/**
 * 添加好友处理器
 *
 * @author: DoubleW2w
 * @date: 2024/4/19 17:08
 * @project: IM-Netty-NaiveChat
 */
public class AddFriendHandler extends MyBizHandler<AddFriendRequest> {

  public AddFriendHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, AddFriendRequest msg) {
    // 1. 添加好友到数据库中[A->B B->A]
    List<UserFriend> userFriendList = new ArrayList<>();
    userFriendList.add(new UserFriend(msg.getUserId(), msg.getFriendId()));
    userFriendList.add(new UserFriend(msg.getFriendId(), msg.getUserId()));
    userService.addUserFriend(userFriendList);

    // 2. 推送好友添加完成 A
    UserInfo userInfo = userService.queryUserInfo(msg.getFriendId());
    channel.writeAndFlush(
        new AddFriendResponse(
            userInfo.getUserId(), userInfo.getUserNickName(), userInfo.getUserHead()));

    // 3. 推送好友添加完成 B
    Channel friendChannel = SocketChannelUtil.getChannel(msg.getFriendId());
    if (null == friendChannel) return;
    UserInfo friendInfo = userService.queryUserInfo(msg.getUserId());
    friendChannel.writeAndFlush(
        new AddFriendResponse(
            friendInfo.getUserId(), friendInfo.getUserNickName(), friendInfo.getUserHead()));
  }
}

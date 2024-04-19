package com.doublew2w.naive.chat.ddd.socket.handler;

import com.doublew2w.naive.chat.ddd.application.UserService;
import com.doublew2w.naive.chat.ddd.domain.user.model.ChatRecordInfo;
import com.doublew2w.naive.chat.ddd.domain.user.model.UserInfo;
import com.doublew2w.naive.chat.ddd.infrastructure.common.dict.Constants;
import com.doublew2w.naive.chat.ddd.infrastructure.util.SocketChannelUtil;
import com.doublew2w.naive.chat.ddd.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.msg.MsgGroupRequest;
import com.doublew2w.naive.chat.protocol.msg.MsgGroupResponse;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

/**
 * 群组消息发送
 *
 * @author: DoubleW2w
 * @date: 2024/4/19 17:08
 * @project: IM-Netty-NaiveChat
 */
public class MsgGroupHandler extends MyBizHandler<MsgGroupRequest> {

  public MsgGroupHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, MsgGroupRequest msg) {
    // 获取群组通信管道
    ChannelGroup channelGroup = SocketChannelUtil.getChannelGroup(msg.getTalkId());
    if (null == channelGroup) {
      SocketChannelUtil.addChannelGroup(msg.getTalkId(), channel);
      channelGroup = SocketChannelUtil.getChannelGroup(msg.getTalkId());
    }
    // 异步写库
    userService.asyncAppendChatRecord(
        new ChatRecordInfo(
            msg.getUserId(),
            msg.getTalkId(),
            msg.getMsgText(),
            msg.getMsgType(),
            msg.getMsgDate(),
            Constants.TalkType.Group.getCode()));
    // 群发消息
    UserInfo userInfo = userService.queryUserInfo(msg.getUserId());
    MsgGroupResponse msgGroupResponse = new MsgGroupResponse();
    msgGroupResponse.setTalkId(msg.getTalkId());
    msgGroupResponse.setUserId(msg.getUserId());
    msgGroupResponse.setUserNickName(userInfo.getUserNickName());
    msgGroupResponse.setUserHead(userInfo.getUserHead());
    msgGroupResponse.setMsg(msg.getMsgText());
    msgGroupResponse.setMsgType(msg.getMsgType());
    msgGroupResponse.setMsgDate(msg.getMsgDate());
    channelGroup.writeAndFlush(msgGroupResponse);
  }
}

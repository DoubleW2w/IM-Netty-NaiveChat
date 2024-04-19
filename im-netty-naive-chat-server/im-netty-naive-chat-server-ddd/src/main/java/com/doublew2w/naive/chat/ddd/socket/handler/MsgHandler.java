package com.doublew2w.naive.chat.ddd.socket.handler;

import com.alibaba.fastjson2.JSON;
import com.doublew2w.naive.chat.ddd.application.UserService;
import com.doublew2w.naive.chat.ddd.domain.user.model.ChatRecordInfo;
import com.doublew2w.naive.chat.ddd.infrastructure.common.dict.Constants;
import com.doublew2w.naive.chat.ddd.infrastructure.util.SocketChannelUtil;
import com.doublew2w.naive.chat.ddd.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.msg.MsgRequest;
import com.doublew2w.naive.chat.protocol.msg.MsgResponse;
import io.netty.channel.Channel;

/**
 * 消息信息处理
 *
 * @author: DoubleW2w
 * @date: 2024/4/19 17:08
 * @project: IM-Netty-NaiveChat
 */
public class MsgHandler extends MyBizHandler<MsgRequest> {

  public MsgHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, MsgRequest msg) {
    logger.info("消息信息处理：{}", JSON.toJSONString(msg));
    // 异步写库
    userService.asyncAppendChatRecord(
        new ChatRecordInfo(
            msg.getUserId(),
            msg.getFriendId(),
            msg.getMsgText(),
            msg.getMsgType(),
            msg.getMsgDate()));
    // 添加对话框[如果对方没有你的对话框则添加]
    userService.addTalkBoxInfo(
        msg.getFriendId(), msg.getUserId(), Constants.TalkType.Friend.getCode());
    // 获取好友通信管道
    Channel friendChannel = SocketChannelUtil.getChannel(msg.getFriendId());
    if (null == friendChannel) {
      logger.info("用户id：{}未登录！", msg.getFriendId());
      return;
    }
    // 发送消息
    friendChannel.writeAndFlush(
        new MsgResponse(msg.getUserId(), msg.getMsgText(), msg.getMsgType(), msg.getMsgDate()));
  }
}

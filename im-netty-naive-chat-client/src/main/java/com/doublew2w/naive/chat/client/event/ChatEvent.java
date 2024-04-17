package com.doublew2w.naive.chat.client.event;

import com.doublew2w.naive.chat.client.infrastructure.util.BeanUtil;
import com.doublew2w.naive.chat.protocol.friend.AddFriendRequest;
import com.doublew2w.naive.chat.protocol.friend.SearchFriendRequest;
import com.doublew2w.naive.chat.protocol.msg.MsgGroupRequest;
import com.doublew2w.naive.chat.protocol.msg.MsgRequest;
import com.doublew2w.naive.chat.protocol.talk.DelTalkRequest;
import com.doublew2w.naive.chat.protocol.talk.TalkNoticeRequest;
import com.doublew2w.naive.chat.ui.view.chat.IChatEvent;
import io.netty.channel.Channel;
import java.util.Date;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 22:52
 * @project: IM-Netty-NaiveChat
 */
public class ChatEvent implements IChatEvent {
  private final Logger logger = LoggerFactory.getLogger(ChatEvent.class);

  @Override
  public void doQuit() {
    logger.info("退出登陆！");
    BeanUtil.getBean("channel", Channel.class).close();
  }

  @Override
  public void doSendMsg(
      String userId, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    // 好友0
    if (0 == talkType) {
      channel.writeAndFlush(new MsgRequest(userId, talkId, msg, msgType, msgDate));
    }
    // 群组1
    else if (1 == talkType) {
      channel.writeAndFlush(new MsgGroupRequest(talkId, userId, msg, msgType, msgDate));
    }
  }

  @Override
  public void doEventAddTalkUser(String userId, String userFriendId) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new TalkNoticeRequest(userId, userFriendId, 0));
  }

  @Override
  public void doEventAddTalkGroup(String userId, String groupId) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new TalkNoticeRequest(userId, groupId, 1));
  }

  @Override
  public void doEventDelTalkUser(String userId, String talkId) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new DelTalkRequest(userId, talkId));
  }

  @Override
  public void addFriendLuck(String userId, ListView<Pane> listView) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new SearchFriendRequest(userId, ""));
  }

  @Override
  public void doFriendLuckSearch(String userId, String text) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new SearchFriendRequest(userId, text));
  }

  @Override
  public void doEventAddLuckUser(String userId, String friendId) {
    Channel channel = BeanUtil.getBean("channel", Channel.class);
    channel.writeAndFlush(new AddFriendRequest(userId, friendId));
  }
}

package com.doublew2w.naive.chat.ddd.infrastructure.util;

import cn.hutool.core.map.SafeConcurrentHashMap;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.Map;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 0:46
 * @project: IM-Netty-NaiveChat
 */
public class SocketChannelUtil {
  // 用户
  private static Map<String, Channel> userChannel = new SafeConcurrentHashMap<>();
  private static Map<String, String> userChannelId = new SafeConcurrentHashMap<>();
  // 群组
  private static Map<String, ChannelGroup> channelGroupMap = new SafeConcurrentHashMap<>();

  public static void addChannel(String userId, Channel channel) {
    userChannel.put(userId, channel);
    userChannelId.put(channel.id().toString(), userId);
  }

  public static void removeChannel(String channelId) {
    String userId = userChannelId.get(channelId);
    if (null == userId) {
        return;
    }
    userChannel.remove(userId);
  }

  public static void removeUserChannelByUserId(String userId) {
    userChannel.remove(userId);
  }

  public static Channel getChannel(String userId) {
    return userChannel.get(userId);
  }

  /**
   * 添加群组成员通信管道
   *
   * @param talkId 对话框ID[群号]
   * @param userChannel 群员通信管道
   */
  public static synchronized void addChannelGroup(String talkId, Channel userChannel) {
    ChannelGroup channelGroup = channelGroupMap.get(talkId);
    if (null == channelGroup) {
      channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
      channelGroupMap.put(talkId, channelGroup);
    }
    channelGroup.add(userChannel);
  }

  public static synchronized void removeChannelGroup(String talkId, Channel userChannel) {
    ChannelGroup channelGroup = channelGroupMap.get(talkId);
    if (null == channelGroup) return;
    channelGroup.remove(userChannel);
  }

  public static void removeChannelGroupByChannel(Channel channel) {
    for (ChannelGroup next : channelGroupMap.values()) {
      next.remove(channel);
    }
  }

  /**
   * 获取群组通信管道
   *
   * @param talkId 对话框ID[群号]
   * @return 群组
   */
  public static ChannelGroup getChannelGroup(String talkId) {
    return channelGroupMap.get(talkId);
  }
}

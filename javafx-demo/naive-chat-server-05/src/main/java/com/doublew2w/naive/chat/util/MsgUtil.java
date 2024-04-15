package com.doublew2w.naive.chat.util;

import com.doublew2w.naive.chat.domain.MsgInfo;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 22:07
 * @project: IM-Netty-NaiveChat
 */
public class MsgUtil {
  public static MsgInfo buildMsg(String channelId, String msgContent) {
    return new MsgInfo(channelId, msgContent);
  }
}

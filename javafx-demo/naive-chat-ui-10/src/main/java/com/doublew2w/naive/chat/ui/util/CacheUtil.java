package com.doublew2w.naive.chat.ui.util;

import com.doublew2w.naive.chat.ui.view.chat.element.group_bar_chat.ElementTalk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/12 21:37
 * @project: IM-Netty-NaiveChat
 */

public class CacheUtil {
  // 对话框组
  public static Map<String, ElementTalk> talkMap = new ConcurrentHashMap<String, ElementTalk>(16);
}

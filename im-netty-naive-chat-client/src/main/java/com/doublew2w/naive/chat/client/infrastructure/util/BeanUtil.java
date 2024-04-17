package com.doublew2w.naive.chat.client.infrastructure.util;

import cn.hutool.core.map.SafeConcurrentHashMap;
import java.util.Map;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 14:48
 * @project: IM-Netty-NaiveChat
 */
public class BeanUtil {
  private static Map<String, Object> cacheMap = new SafeConcurrentHashMap<>();

    public static synchronized void addBean(String name, Object obj) {
        cacheMap.put(name, obj);
    }

    public static <T> T getBean(String name, Class<T> t) {
        return (T) cacheMap.get(name);
    }
}

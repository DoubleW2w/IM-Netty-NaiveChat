package com.doublew2w.naive.chat.infrastructure.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 缓存操作工具率
 *
 * @author: DoubleW2w
 * @date: 2024/4/14 19:53
 * @project: IM-Netty-NaiveChat
 */
@Service("redisUtil")
public class RedisUtil {

  @Autowired private StringRedisTemplate redisTemplate;

  public void set(String key, String value) {
    redisTemplate.opsForValue().set(key, value);
  }

  public String get(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  public void delete(String key) {
    redisTemplate.delete(key);
  }
}

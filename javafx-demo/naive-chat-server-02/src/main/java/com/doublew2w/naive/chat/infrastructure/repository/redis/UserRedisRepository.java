package com.doublew2w.naive.chat.infrastructure.repository.redis;

import com.alibaba.fastjson2.JSON;
import com.doublew2w.naive.chat.domain.repository.IUserRepository;
import com.doublew2w.naive.chat.infrastructure.po.UserEntity;
import com.doublew2w.naive.chat.infrastructure.util.RedisUtil;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author: DoubleW2w
 * @date: 2024/4/14 19:56
 * @project: IM-Netty-NaiveChat
 */
@Repository("userRedisRepository")
public class UserRedisRepository implements IUserRepository {

  @Resource(name = "redisUtil")
  private RedisUtil redisUtil;

  @Override
  public void save(UserEntity userEntity) {
    redisUtil.set("itstack-demo-ddd-userinfo", JSON.toJSONString(userEntity));
  }

  @Override
  public UserEntity query(Long id) {
    String objJson = redisUtil.get("itstack-demo-ddd-userinfo");
    return JSON.parseObject(objJson, UserEntity.class);
  }
}

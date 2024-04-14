package com.doublew2w.naive.chat.infrastructure.repository;

import com.doublew2w.naive.chat.domain.repository.IUserRepository;
import com.doublew2w.naive.chat.infrastructure.po.UserEntity;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author: DoubleW2w
 * @date: 2024/4/14 20:27
 * @project: IM-Netty-NaiveChat
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

  @Resource(name = "userMysqlRepository")
  private IUserRepository userMysqlRepository;

  @Resource(name = "userRedisRepository")
  private IUserRepository userRedisRepository;

  @Override
  public void save(UserEntity userEntity) {
    // 保存到DB
    userMysqlRepository.save(userEntity);

    // 保存到Redis
    userRedisRepository.save(userEntity);
  }

  @Override
  public UserEntity query(Long id) {

    UserEntity userEntityRedis = userRedisRepository.query(id);
    if (null != userEntityRedis) return userEntityRedis;

    UserEntity userEntityMysql = userMysqlRepository.query(id);
    if (null != userEntityMysql) {
      // 保存到Redis
      userRedisRepository.save(userEntityMysql);
      return userEntityMysql;
    }

    // 查询为NULL
    return null;
  }
}

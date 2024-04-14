package com.doublew2w.naive.chat.infrastructure.repository.mysql;

import com.doublew2w.naive.chat.domain.repository.IUserRepository;
import com.doublew2w.naive.chat.infrastructure.dao.UserDao;
import com.doublew2w.naive.chat.infrastructure.po.UserEntity;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author: DoubleW2w
 * @date: 2024/4/14 19:56
 * @project: IM-Netty-NaiveChat
 */
@Repository("userMysqlRepository")
public class UserMysqlRepository implements IUserRepository {

  @Resource private UserDao userDao;

  @Override
  public void save(UserEntity userEntity) {
    userDao.save(userEntity);
  }

  @Override
  public UserEntity query(Long id) {
    return userDao.query(id);
  }
}

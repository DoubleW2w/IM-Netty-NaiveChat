package com.doublew2w.naive.chat.infrastructure.dao.impl;

import com.doublew2w.naive.chat.infrastructure.dao.UserDao;
import com.doublew2w.naive.chat.infrastructure.po.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:49
 * @project: IM-Netty-NaiveChat
 */
@Service
public class UserDaoImpl implements UserDao {
  @Override
  public void save(UserEntity userEntity) {
    // TODO 数据库操作
  }

  @Override
  public UserEntity query(Long id) {
    // TODO 数据库操作
    return null;
  }
}

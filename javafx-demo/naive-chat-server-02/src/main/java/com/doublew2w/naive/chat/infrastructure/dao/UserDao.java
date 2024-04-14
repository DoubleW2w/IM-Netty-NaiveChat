package com.doublew2w.naive.chat.infrastructure.dao;

import com.doublew2w.naive.chat.infrastructure.po.UserEntity;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:49
 * @project: IM-Netty-NaiveChat
 */
public interface UserDao {

  void save(UserEntity userEntity);

  UserEntity query(Long id);
}

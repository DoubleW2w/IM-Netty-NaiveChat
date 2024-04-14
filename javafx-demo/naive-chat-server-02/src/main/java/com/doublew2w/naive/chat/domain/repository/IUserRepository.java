package com.doublew2w.naive.chat.domain.repository;

import com.doublew2w.naive.chat.infrastructure.po.UserEntity;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:41
 * @project: IM-Netty-NaiveChat
 */

public interface IUserRepository {
  void save(UserEntity userEntity);

  UserEntity query(Long id);
}

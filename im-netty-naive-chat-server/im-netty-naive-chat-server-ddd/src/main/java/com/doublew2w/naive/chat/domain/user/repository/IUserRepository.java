package com.doublew2w.naive.chat.domain.user.repository;

import com.doublew2w.naive.chat.domain.user.model.UserInfo;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 9:27
 * @project: IM-Netty-NaiveChat
 */
public interface IUserRepository {
  /**
   * 查询用户密码
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  String queryUserPassword(String userId);

  /**
   * 查询用户信息
   *
   * @param userId 用户ID
   * @return 用户信息
   */
  UserInfo queryUserInfo(String userId);
}

package com.doublew2w.naive.chat.application.service;

import com.doublew2w.naive.chat.domain.model.aggrate.UserRichInfo;

/**
 * 应用层用户服务
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:36
 * @project: IM-Netty-NaiveChat
 */
public interface UserService {
  UserRichInfo queryUserInfoById(Long id);
}

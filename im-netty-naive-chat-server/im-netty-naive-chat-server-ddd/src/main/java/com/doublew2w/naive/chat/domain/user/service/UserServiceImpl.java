package com.doublew2w.naive.chat.domain.user.service;

import cn.hutool.core.thread.ThreadUtil;
import com.doublew2w.naive.chat.application.UserService;
import com.doublew2w.naive.chat.domain.user.model.UserInfo;
import com.doublew2w.naive.chat.domain.user.repository.IUserRepository;
import java.util.concurrent.ExecutorService;
import javax.annotation.Resource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource private IUserRepository userRepository;
  @Resource private ThreadPoolTaskExecutor taskExecutor;

  // 默认线程池
  private static final ExecutorService executorService =
      ThreadUtil.newFixedExecutor(4, "userService", true);

  @Override
  public boolean checkAuth(String userId, String userPassword) {
    // 简单比对验证
    String authCode = userRepository.queryUserPassword(userId);
    return userPassword.equals(authCode);
  }

  @Override
  public UserInfo queryUserInfo(String userId) {
    return userRepository.queryUserInfo(userId);
  }
}

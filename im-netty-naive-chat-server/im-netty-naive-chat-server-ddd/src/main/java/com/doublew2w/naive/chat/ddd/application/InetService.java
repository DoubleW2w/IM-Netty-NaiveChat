package com.doublew2w.naive.chat.ddd.application;

import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserInfo;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserReq;
import com.doublew2w.naive.chat.ddd.domain.inet.model.InetServerInfo;
import java.util.List;

/**
 * 网络信息服务
 *
 * @author: DoubleW2w
 * @date: 2024/4/19 18:24
 * @project: IM-Netty-NaiveChat
 */
public interface InetService {
  InetServerInfo queryNettyServerInfo();

  Long queryChannelUserCount(ChannelUserReq req);

  List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);
}

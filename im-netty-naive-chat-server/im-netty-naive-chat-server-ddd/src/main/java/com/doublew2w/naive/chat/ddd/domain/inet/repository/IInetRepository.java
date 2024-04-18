package com.doublew2w.naive.chat.ddd.domain.inet.repository;

import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserInfo;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserReq;
import java.util.List;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:12
 * @project: IM-Netty-NaiveChat
 */

public interface IInetRepository {
  Long queryChannelUserCount(ChannelUserReq req);

  List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);
}

package com.doublew2w.naive.chat.ddd.infrastructure.repository;

import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserInfo;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserReq;
import com.doublew2w.naive.chat.ddd.domain.inet.repository.IInetRepository;
import com.doublew2w.naive.chat.ddd.infrastructure.dao.IUserDao;
import com.doublew2w.naive.chat.ddd.infrastructure.po.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:13
 * @project: IM-Netty-NaiveChat
 */
@Repository("inetRepository")
public class InetRepository implements IInetRepository {
  @Resource
  private IUserDao userDao;

  @Override
  public Long queryChannelUserCount(ChannelUserReq req) {
    return userDao.queryChannelUserCount(req);
  }

  @Override
  public List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req) {
    List<ChannelUserInfo> channelUserInfoList = new ArrayList<>();
    List<User> userList = userDao.queryChannelUserList(req);
    for (User user:userList){
      ChannelUserInfo channelUserInfo = new ChannelUserInfo();
      channelUserInfo.setUserId(user.getUserId());
      channelUserInfo.setUserNickName(user.getUserNickName());
      channelUserInfo.setUserHead(user.getUserHead());
      channelUserInfoList.add(channelUserInfo);
    }
    return channelUserInfoList;
  }
}

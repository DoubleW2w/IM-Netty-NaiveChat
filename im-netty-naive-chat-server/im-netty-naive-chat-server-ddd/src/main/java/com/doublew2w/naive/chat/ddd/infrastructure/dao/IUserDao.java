package com.doublew2w.naive.chat.ddd.infrastructure.dao;

import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserReq;
import com.doublew2w.naive.chat.ddd.infrastructure.po.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: DoubleW2w
 * @date: 2024/4/18 23:58
 * @project: IM-Netty-NaiveChat
 */
@Mapper
public interface IUserDao {
  String queryUserPassword(@Param("userId") String userId);

  User queryUserById(@Param("userId") String userId);

  List<User> queryFuzzyUserList(@Param("userId") String userId, @Param("searchKey") String searchKey);

  Long queryChannelUserCount(@Param("req") ChannelUserReq req);

  List<User> queryChannelUserList(@Param("req") ChannelUserReq req);
}

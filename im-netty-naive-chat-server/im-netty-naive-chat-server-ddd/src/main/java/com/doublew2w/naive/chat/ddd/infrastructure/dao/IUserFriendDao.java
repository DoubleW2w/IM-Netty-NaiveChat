package com.doublew2w.naive.chat.ddd.infrastructure.dao;

import com.doublew2w.naive.chat.ddd.infrastructure.po.UserFriend;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: DoubleW2w
 * @date: 2024/4/18 23:58
 * @project: IM-Netty-NaiveChat
 */
@Mapper
public interface IUserFriendDao {
  List<String> queryUserFriendIdList(@Param("userId") String userId);

  UserFriend queryUserFriendById(@Param("req") UserFriend req);

  void addUserFriendList(@Param("list") List<UserFriend> list);
}

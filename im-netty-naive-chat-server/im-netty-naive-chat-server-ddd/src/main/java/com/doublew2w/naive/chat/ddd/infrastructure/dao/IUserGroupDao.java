package com.doublew2w.naive.chat.ddd.infrastructure.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: DoubleW2w
 * @date: 2024/4/18 23:58
 * @project: IM-Netty-NaiveChat
 */
@Mapper
public interface IUserGroupDao {
  List<String> queryUserGroupsIdList(String userId);
}

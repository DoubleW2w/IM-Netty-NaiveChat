package com.doublew2w.naive.chat.ddd.infrastructure.dao;

import com.doublew2w.naive.chat.ddd.infrastructure.po.Groups;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: DoubleW2w
 * @date: 2024/4/18 23:57
 * @project: IM-Netty-NaiveChat
 */
@Mapper
public interface IGroupsDao {
  Groups queryGroupsById(String groupsId);
}

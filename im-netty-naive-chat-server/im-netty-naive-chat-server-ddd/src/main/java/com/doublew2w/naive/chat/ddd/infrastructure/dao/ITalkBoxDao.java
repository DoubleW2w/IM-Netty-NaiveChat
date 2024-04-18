package com.doublew2w.naive.chat.ddd.infrastructure.dao;

import com.doublew2w.naive.chat.ddd.infrastructure.po.TalkBox;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: DoubleW2w
 * @date: 2024/4/18 23:57
 * @project: IM-Netty-NaiveChat
 */
@Mapper
public interface ITalkBoxDao {
  List<TalkBox> queryTalkBoxList(@Param("userId") String userId);

  void addTalkBox(@Param("talkBox") TalkBox talkBox);

  void deleteUserTalk(@Param("userId") String userId, @Param("talkId") String talkId);

  TalkBox queryTalkBox(@Param("userId") String userId, @Param("talkId") String talkId);

  List<String> queryTalkBoxGroupsIdList(@Param("userId") String userId);
}

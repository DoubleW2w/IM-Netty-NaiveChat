package com.doublew2w.naive.chat.ddd.infrastructure.dao;

import com.doublew2w.naive.chat.ddd.infrastructure.po.ChatRecord;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: DoubleW2w
 * @date: 2024/4/18 23:54
 * @project: IM-Netty-NaiveChat
 */
@Mapper
public interface IChatRecordDao {

  void appendChatRecord(@Param("req") ChatRecord req);

  List<ChatRecord> queryUserChatRecordList(
      @Param("talkId") String talkId, @Param("userId") String userId);

  List<ChatRecord> queryGroupsChatRecordList(
      @Param("talkId") String talkId, @Param("userId") String userId);
}

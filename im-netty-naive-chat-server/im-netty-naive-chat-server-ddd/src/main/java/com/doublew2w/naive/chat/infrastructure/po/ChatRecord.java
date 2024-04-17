package com.doublew2w.naive.chat.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 聊天记录
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ChatRecord {

  private Long id; // 自增ID
  private String userId; // 用户ID
  private String friendId; // 好友ID/TalkId/群组ID
  private String msgContent; // 消息内容
  private Integer msgType; // 消息类型；0文字消息、1固定表情
  private Date msgDate; // 消息时间
  private Integer talkType; // 对话框类型；0好友、1群组
  private Date createTime; // 创建时间
  private Date updateTime; // 更新时间

}

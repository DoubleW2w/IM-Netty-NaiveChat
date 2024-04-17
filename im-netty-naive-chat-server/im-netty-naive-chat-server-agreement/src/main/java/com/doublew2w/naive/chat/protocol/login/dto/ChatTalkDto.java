package com.doublew2w.naive.chat.protocol.login.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/16 23:24
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ChatTalkDto {
  /** 对话框ID */
  private String talkId;

  /** 对话框类型；0好友、1群组 */
  private Integer talkType;

  /** 用户昵称 */
  private String talkName;

  /** 用户头像 */
  private String talkHead;

  /** 消息简述 */
  private String talkSketch;

  /** 消息时间 */
  private Date talkDate;

  /** 聊天记录 */
  private List<ChatRecordDto> chatRecordList;
}

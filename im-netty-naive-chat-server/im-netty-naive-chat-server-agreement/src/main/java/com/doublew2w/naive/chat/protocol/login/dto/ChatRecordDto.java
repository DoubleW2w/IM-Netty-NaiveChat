package com.doublew2w.naive.chat.protocol.login.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 14:04
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class ChatRecordDto {
  /** 对话框ID */
  private String talkId;

  /** 用户ID[自己/好友] */
  private String userId;

  /** 用户昵称[群组聊天] */
  private String userNickName;

  /** 用户头像[群组聊天] */
  private String userHead;

  /** 消息类型[0自己/1好友] */
  private Integer msgUserType;

  /** 消息内容 */
  private String msgContent;

  /**  消息类型；0文字消息、1固定表情 */
  private Integer msgType;

  /**  消息时间 */
  private LocalDateTime msgDate;
}

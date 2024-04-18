package com.doublew2w.naive.chat.ddd.domain.user.model;

import com.doublew2w.naive.chat.ddd.infrastructure.common.dict.Constants;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 14:05
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
@NoArgsConstructor
public class ChatRecordInfo {
  /** 用户ID */
  private String userId;

  /** 好友ID */
  private String friendId;

  /** 消息内容 */
  private String msgContent;

  /** 消息类型；0文字消息、1固定表情 */
  private Integer msgType;

  /** 消息时间 */
  private Date msgDate;

  /** 对话框类型；0好友、1群组 */
  private Integer talkType;



  public ChatRecordInfo(String userId, String friendId, String msgContent, Integer msgType, Date msgDate) {
    this.friendId = friendId;
    this.userId = userId;
    this.msgContent = msgContent;
    this.msgType = msgType;
    this.msgDate = msgDate;
    this.talkType = Constants.TalkType.Friend.getCode();
  }

  public ChatRecordInfo(String userId, String friendId, String msgContent, Integer msgType, Date msgDate, Integer talkType) {
    this.friendId = friendId;
    this.userId = userId;
    this.msgContent = msgContent;
    this.msgType = msgType;
    this.msgDate = msgDate;
    this.talkType = talkType;
  }
}

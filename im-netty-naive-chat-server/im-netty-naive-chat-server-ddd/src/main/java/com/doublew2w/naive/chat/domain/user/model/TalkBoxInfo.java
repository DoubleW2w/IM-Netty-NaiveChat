package com.doublew2w.naive.chat.domain.user.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 12:29
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class TalkBoxInfo {
  /** 对话框类型；0好友、1群组 */
  private Integer talkType;

  /** 对话框ID(好友ID、群组ID) */
  private String talkId;

  /** 对话框名称 */
  private String talkName;

  /** 对话框头像 */
  private String talkHead;

  /** 消息简述 */
  private String talkSketch;

  /** 消息时间 */
  private LocalDateTime talkDate;
}

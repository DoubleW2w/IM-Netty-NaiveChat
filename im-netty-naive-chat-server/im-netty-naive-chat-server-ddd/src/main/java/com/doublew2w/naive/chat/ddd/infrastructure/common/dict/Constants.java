package com.doublew2w.naive.chat.ddd.infrastructure.common.dict;

import lombok.Getter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 12:41
 * @project: IM-Netty-NaiveChat
 */
public class Constants {
  @Getter
  public enum ResponseCode {
    /** 成功 */
    SUCCESS("0000", "成功"),
    /** 未知失败 */
    UN_ERROR("0001", "未知失败"),
    /** 非法参数 */
    ILLEGAL_PARAMETER("0002", "非法参数"),
    /** 主键冲突 */
    INDEX_DUP("0003", "主键冲突");

    private String code;
    private String info;

    ResponseCode(String code, String info) {
      this.code = code;
      this.info = info;
    }
  }

  @Getter
  public enum TalkType {
    Friend(0, "好友"),
    Group(1, "群组");

    private Integer code;
    private String info;

    TalkType(Integer code, String info) {
      this.code = code;
      this.info = info;
    }
  }

  @Getter
  public enum MsgType {
    Myself(0, "自己"),
    Friend(1, "好友");

    private Integer code;
    private String info;

    MsgType(Integer code, String info) {
      this.code = code;
      this.info = info;
    }
  }
}

package com.doublew2w.naive.chat.ddd.infrastructure.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:09
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class EasyResult {
  private Integer code;
  private String msg;
  private Long count;
  private Object data;

  public static EasyResult buildEasyResultError(String message) {
    return new EasyResult(1, message);
  }

  public static EasyResult buildEasyResultError(Exception e) {
    return new EasyResult(1, e.getMessage());
  }

  public static EasyResult buildEasyResultSuccess(Object data) {
    return new EasyResult(0, "", 1L, data);
  }

  public static EasyResult buildEasyResultSuccess(Long count, Object data) {
    return new EasyResult(0, "", count, data);
  }

  public static EasyResult buildEasyResultSuccess() {
    return new EasyResult(0, "");
  }

  public EasyResult(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public EasyResult(Integer code, String msg, Long count, Object data) {
    this.code = code;
    this.msg = msg;
    this.count = count;
    this.data = data;
  }
}

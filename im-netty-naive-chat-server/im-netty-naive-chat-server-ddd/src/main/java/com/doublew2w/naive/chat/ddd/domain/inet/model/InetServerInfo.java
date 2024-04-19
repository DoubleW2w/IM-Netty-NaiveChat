package com.doublew2w.naive.chat.ddd.domain.inet.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:07
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class InetServerInfo {
  /** IP */
  private String ip;

  /** 端口 */
  private int port;

  /** 状态；true开启、false关闭 */
  private boolean status;
}

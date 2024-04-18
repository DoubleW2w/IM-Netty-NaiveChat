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
  private String ip;      // IP
  private int port;       // 端口
  private boolean status; // 状态；true开启、false关闭
}

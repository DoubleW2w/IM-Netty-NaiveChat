package com.doublew2w.naive.chat.ddd.infrastructure.common;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 0:07
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class PageReq {
  private int pageStart = 0; // 开始 limit 第一个参数
  private int pageEnd = 0; // 结束 limit 第二个参数

  private int page; // 页数
  private int rows; // 行数

  public PageReq() {}

  public PageReq(String page, String rows) {
    this.page = StringUtils.isEmpty(page) ? 1 : Integer.parseInt(page);
    this.rows = StringUtils.isEmpty(page) ? 10 : Integer.parseInt(rows);
    if (0 == this.page) {
      this.page = 1;
    }
    this.pageStart = (this.page - 1) * this.rows;
    this.pageEnd = this.rows;
  }

  public void setPage(String page, String rows) {
    this.page = StringUtils.isEmpty(page) ? 1 : Integer.parseInt(page);
    this.rows = StringUtils.isEmpty(page) ? 10 : Integer.parseInt(rows);
    if (0 == this.page) {
      this.page = 1;
    }
    this.pageStart = (this.page - 1) * this.rows;
    this.pageEnd = this.rows;
  }
}

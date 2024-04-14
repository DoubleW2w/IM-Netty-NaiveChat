package com.doublew2w.naive.chat.domain.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:39
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserSchool {
  /** 学校名称 */
  private String schoolName;

  /** 学校地址 */
  private String schoolAddress;

  /** 入学时间 */
  private String entranceDate;

  /** 毕业时间 */
  private String graduationDate;
}

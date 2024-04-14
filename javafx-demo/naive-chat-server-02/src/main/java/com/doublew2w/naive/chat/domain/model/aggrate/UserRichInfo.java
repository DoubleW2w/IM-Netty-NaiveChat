package com.doublew2w.naive.chat.domain.model.aggrate;

import com.doublew2w.naive.chat.domain.model.vo.UserInfo;
import com.doublew2w.naive.chat.domain.model.vo.UserSchool;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:38
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserRichInfo {
  private UserInfo userInfo;
  private List<UserSchool> userSchoolList;

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public List<UserSchool> getUserSchoolList() {
    return userSchoolList;
  }

  public void setUserSchoolList(List<UserSchool> userSchoolList) {
    this.userSchoolList = userSchoolList;
  }
}

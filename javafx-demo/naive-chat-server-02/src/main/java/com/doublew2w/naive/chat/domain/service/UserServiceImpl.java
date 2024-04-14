package com.doublew2w.naive.chat.domain.service;

import com.doublew2w.naive.chat.application.service.UserService;
import com.doublew2w.naive.chat.domain.model.aggrate.UserRichInfo;
import com.doublew2w.naive.chat.domain.model.vo.UserInfo;
import com.doublew2w.naive.chat.domain.model.vo.UserSchool;
import com.doublew2w.naive.chat.domain.repository.IUserRepository;
import com.doublew2w.naive.chat.infrastructure.po.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @date: 2024/4/14 20:23
 * @project: IM-Netty-NaiveChat
 */
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource(name = "userRepository")
  private IUserRepository userRepository;

  @Override
  public UserRichInfo queryUserInfoById(Long id) {

    // 查询资源库
    UserEntity userEntity = userRepository.query(id);

    UserInfo userInfo = new UserInfo();
    userInfo.setName(userEntity.getName());

    // TODO 查询学校信息，外部接口
    UserSchool userSchool_01 = new UserSchool();
    userSchool_01.setSchoolName("振华高级实验中学");

    UserSchool userSchool_02 = new UserSchool();
    userSchool_02.setSchoolName("东北电力大学");

    List<UserSchool> userSchoolList = new ArrayList<>();
    userSchoolList.add(userSchool_01);
    userSchoolList.add(userSchool_02);

    UserRichInfo userRichInfo = new UserRichInfo();
    userRichInfo.setUserInfo(userInfo);
    userRichInfo.setUserSchoolList(userSchoolList);

    return userRichInfo;
  }
}

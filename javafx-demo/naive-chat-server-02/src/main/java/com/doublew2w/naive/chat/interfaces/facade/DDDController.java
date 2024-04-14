package com.doublew2w.naive.chat.interfaces.facade;

import com.doublew2w.naive.chat.application.service.UserService;
import com.doublew2w.naive.chat.interfaces.UserInfoDto;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/14 19:43
 * @project: IM-Netty-NaiveChat
 */
@Controller
public class DDDController {
  @Resource(name = "userService")
  private UserService userService;

  @RequestMapping("/index")
  public String index(Model model) {
    return "index";
  }

  @RequestMapping("/api/user/queryUserInfo")
  @ResponseBody
  public ResponseEntity queryUserInfo(@RequestBody UserInfoDto request) {
    return new ResponseEntity<>(userService.queryUserInfoById(request.getId()), HttpStatus.OK);
  }
}

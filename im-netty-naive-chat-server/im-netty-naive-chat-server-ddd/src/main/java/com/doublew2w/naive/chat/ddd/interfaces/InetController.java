package com.doublew2w.naive.chat.ddd.interfaces;

import com.alibaba.fastjson2.JSON;
import com.doublew2w.naive.chat.ddd.application.InetService;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserInfo;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserReq;
import com.doublew2w.naive.chat.ddd.domain.inet.model.InetServerInfo;
import com.doublew2w.naive.chat.ddd.infrastructure.common.EasyResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 18:29
 * @project: IM-Netty-NaiveChat
 */
@Controller
public class InetController {
  private final Logger logger = LoggerFactory.getLogger(InetController.class);

  @Resource private InetService inetService;

  @RequestMapping("api/queryNettyServerInfo")
  @ResponseBody
  public EasyResult queryNettyServerInfo() {
    try {
      InetServerInfo inetServerInfo = inetService.queryNettyServerInfo();
      List<InetServerInfo> list = new ArrayList<>();
      list.add(inetServerInfo);
      return EasyResult.buildEasyResultSuccess(list);
    } catch (Exception e) {
      logger.info("查询NettyServer失败。", e);
      return EasyResult.buildEasyResultError(e);
    }
  }

  @RequestMapping("api/queryChannelUserList")
  @ResponseBody
  public EasyResult queryChannelUserList(String json, String page, String limit) {
    try {
      logger.info("查询通信管道用户信息列表开始。req：{}", json);
      ChannelUserReq req = JSON.parseObject(json, ChannelUserReq.class);
      if (null == req) req = new ChannelUserReq();
      req.setPage(page, limit);
      Long count = inetService.queryChannelUserCount(req);
      List<ChannelUserInfo> list = inetService.queryChannelUserList(req);
      logger.info("查询通信管道用户信息列表完成。list：{}", JSON.toJSONString(list));
      return EasyResult.buildEasyResultSuccess(count, list);
    } catch (Exception e) {
      logger.info("查询通信管道用户信息列表失败。req：{}", json, e);
      return EasyResult.buildEasyResultError(e);
    }
  }
}

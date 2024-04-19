package com.doublew2w.naive.chat.ddd.socket.handler;

import com.alibaba.fastjson2.JSON;
import com.doublew2w.naive.chat.ddd.application.UserService;
import com.doublew2w.naive.chat.ddd.domain.user.model.LuckUserInfo;
import com.doublew2w.naive.chat.ddd.socket.MyBizHandler;
import com.doublew2w.naive.chat.protocol.friend.SearchFriendRequest;
import com.doublew2w.naive.chat.protocol.friend.SearchFriendResponse;
import com.doublew2w.naive.chat.protocol.friend.dto.SearchUserDto;
import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 17:08
 * @project: IM-Netty-NaiveChat
 */
public class SearchFriendHandler extends MyBizHandler<SearchFriendRequest> {

  public SearchFriendHandler(UserService userService) {
    super(userService);
  }

  @Override
  public void channelRead(Channel channel, SearchFriendRequest msg) {
    logger.info("搜索好友请求处理：{}", JSON.toJSONString(msg));
    List<SearchUserDto> searchUserDtoList = new ArrayList<>();
    List<LuckUserInfo> userInfoList = userService.queryFuzzyUserInfoList(msg.getUserId(), msg.getSearchKey());
    for (LuckUserInfo userInfo : userInfoList) {
      SearchUserDto searchUserDto = new SearchUserDto();
      searchUserDto.setUserId(userInfo.getUserId());
      searchUserDto.setUserNickName(userInfo.getUserNickName());
      searchUserDto.setUserHead(userInfo.getUserHead());
      searchUserDto.setStatus(userInfo.getStatus());
      searchUserDtoList.add(searchUserDto);
      SearchFriendResponse response = new SearchFriendResponse();
      response.setList(searchUserDtoList);
      channel.writeAndFlush(response);
    }
  }
}

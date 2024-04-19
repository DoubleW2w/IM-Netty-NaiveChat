package com.doublew2w.naive.chat.ddd.domain.inet.service;

import com.doublew2w.naive.chat.ddd.application.InetService;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserInfo;
import com.doublew2w.naive.chat.ddd.domain.inet.model.ChannelUserReq;
import com.doublew2w.naive.chat.ddd.domain.inet.model.InetServerInfo;
import com.doublew2w.naive.chat.ddd.domain.inet.repository.IInetRepository;
import com.doublew2w.naive.chat.ddd.infrastructure.util.SocketChannelUtil;
import com.doublew2w.naive.chat.ddd.socket.NettyServer;
import io.netty.channel.Channel;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: DoubleW2w
 * @date: 2024/4/19 18:26
 * @project: IM-Netty-NaiveChat
 */
@Service("inetService")
public class InetServiceImpl implements InetService {

  private final Logger logger = LoggerFactory.getLogger(InetServiceImpl.class);

  @Value("${netty.ip}")
  private String ip;

  @Value("${netty.port}")
  private int port;

  @Resource private NettyServer nettyServer;
  @Resource private IInetRepository inetRepository;

  @Override
  public InetServerInfo queryNettyServerInfo() {
    InetServerInfo inetServerInfo = new InetServerInfo();
    inetServerInfo.setIp(ip);
    inetServerInfo.setPort(port);
    inetServerInfo.setStatus(nettyServer.channel().isActive());
    return inetServerInfo;
  }

  @Override
  public Long queryChannelUserCount(ChannelUserReq req) {
    return inetRepository.queryChannelUserCount(req);
  }

  @Override
  public List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req) {
    List<ChannelUserInfo> channelUserInfoList = inetRepository.queryChannelUserList(req);
    for (ChannelUserInfo channelUserInfo : channelUserInfoList) {
      Channel channel = SocketChannelUtil.getChannel(channelUserInfo.getUserId());
      if (null == channel || !channel.isActive()) {
        channelUserInfo.setStatus(false);
      } else {
        channelUserInfo.setStatus(true);
      }
    }
    return channelUserInfoList;
  }
}

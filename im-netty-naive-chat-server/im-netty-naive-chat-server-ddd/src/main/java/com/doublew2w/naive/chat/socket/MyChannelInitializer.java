package com.doublew2w.naive.chat.socket;

import com.doublew2w.naive.chat.application.UserService;
import com.doublew2w.naive.chat.codec.ObjDecoder;
import com.doublew2w.naive.chat.codec.ObjEncoder;
import com.doublew2w.naive.chat.socket.handler.LoginHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 0:32
 * @project: IM-Netty-NaiveChat
 */
public class MyChannelInitializer extends ChannelInitializer {
  private UserService userService;

  public MyChannelInitializer(UserService userService) {
    this.userService = userService;
  }

  @Override
  protected void initChannel(Channel channel) throws Exception {
    //对象传输处理[解码]
    channel.pipeline().addLast(new ObjDecoder());
    // 在管道中添加我们自己的接收数据实现方法
    channel.pipeline().addLast(new LoginHandler(userService));
    //对象传输处理[编码]
    channel.pipeline().addLast(new ObjEncoder());
  }
}

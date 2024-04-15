package com.doublew2w.naive.chat.client;

import com.doublew2w.naive.chat.codec.ObjDecoder;
import com.doublew2w.naive.chat.codec.ObjEncoder;
import com.doublew2w.naive.chat.domain.MsgInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 初始化数据通信管道
 *
 * @author: DoubleW2w
 * @date: 2024/4/15 21:17
 * @project: IM-Netty-NaiveChat
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel channel) throws Exception {
    //对象传输处理
    channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
    channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
    // 在管道中添加我们自己的接收数据实现方法
    channel.pipeline().addLast(new MyClientHandler());
  }
}

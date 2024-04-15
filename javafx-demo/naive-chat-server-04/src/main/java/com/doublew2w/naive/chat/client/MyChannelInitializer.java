package com.doublew2w.naive.chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import java.nio.charset.Charset;

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
    // 基于换行符号
    channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
    // 解码转String，注意调整自己的编码格式GBK、UTF-8
    channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
    // 编码转String，注意调整自己的编码格式GBK、UTF-8
    channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
    // 在管道中添加我们自己的接收数据实现方法
    channel.pipeline().addLast(new MyClientHandler());
  }
}

package com.doublew2w.naive.chat.codec;

import com.doublew2w.naive.chat.protocol.Packet;
import com.doublew2w.naive.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: DoubleW2w
 * @description: 编码器
 * @date: 2024/4/16 16:54
 * @project: IM-Netty-NaiveChat
 */
public class ObjEncoder extends MessageToByteEncoder<Packet> {
  @Override
  protected void encode(ChannelHandlerContext channelHandlerContext, Packet in, ByteBuf out)
      throws Exception {
    byte[] data = SerializationUtil.serialize(in);
    // 写入缓存区的长度为 data+1（包含了指令的一个字节）
    out.writeInt(data.length + 1);
    // 添加指令，让对象有固定的标识
    out.writeByte(in.getCommand());
    // 添加对象
    out.writeBytes(data);
  }
}

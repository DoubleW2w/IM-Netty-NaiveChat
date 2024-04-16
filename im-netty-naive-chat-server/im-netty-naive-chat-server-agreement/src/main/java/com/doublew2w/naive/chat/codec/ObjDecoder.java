package com.doublew2w.naive.chat.codec;

import com.doublew2w.naive.chat.protocol.Packet;
import com.doublew2w.naive.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * 解码器
 *
 * <p>1.解析时候读取指令码
 *
 * <p>2.通过获取对象类型传输对象的转换
 *
 * @author: DoubleW2w
 * @date: 2024/4/16 22:39
 * @project: IM-Netty-NaiveChat
 */
public class ObjDecoder extends ByteToMessageDecoder {
  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out)
      throws Exception {
    // 不足4个字节
    if (in.readableBytes() < 4) {
      return;
    }
    in.markReaderIndex();
    // 可读字节的长度不足数据长度
    int dataLength = in.readInt();
    if (in.readableBytes() < dataLength) {
      in.resetReaderIndex();
      return;
    }
    // 读取指令
    byte command = in.readByte();
    byte[] data = new byte[dataLength - 1];
    // 读取完整数据
    in.readBytes(data);
    out.add(SerializationUtil.deserialize(data, Packet.get(command)));
  }
}

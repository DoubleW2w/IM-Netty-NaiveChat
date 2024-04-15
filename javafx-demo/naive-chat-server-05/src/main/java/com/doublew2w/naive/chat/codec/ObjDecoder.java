package com.doublew2w.naive.chat.codec;

import com.doublew2w.naive.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 21:52
 * @project: IM-Netty-NaiveChat
 */
public class ObjDecoder extends ByteToMessageDecoder {
  private Class<?> genericClass;

  public ObjDecoder(Class<?> genericClass) {
    this.genericClass = genericClass;
  }

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list)
      throws Exception {
    if (in.readableBytes() < 4) {
      return;
    }
    in.markReaderIndex();
    int dataLength = in.readInt();
    if (in.readableBytes() < dataLength) {
      in.resetReaderIndex();
      return;
    }
    byte[] data = new byte[dataLength];
    in.readBytes(data);
    list.add(SerializationUtil.deserialize(data, genericClass));
  }
}

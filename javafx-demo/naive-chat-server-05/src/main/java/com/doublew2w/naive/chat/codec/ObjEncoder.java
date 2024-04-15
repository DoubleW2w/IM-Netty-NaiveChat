package com.doublew2w.naive.chat.codec;

import com.doublew2w.naive.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: DoubleW2w
 * @date: 2024/4/15 21:56
 * @project: IM-Netty-NaiveChat
 */
public class ObjEncoder extends MessageToByteEncoder {
  private Class<?> genericClass;

  public ObjEncoder(Class<?> genericClass) {
    this.genericClass = genericClass;
  }

  @Override
  protected void encode(ChannelHandlerContext ctx, Object in, ByteBuf out)  {
    if (genericClass.isInstance(in)) {
      byte[] data = SerializationUtil.serialize(in);
      out.writeInt(data.length);
      out.writeBytes(data);
    }
  }
}

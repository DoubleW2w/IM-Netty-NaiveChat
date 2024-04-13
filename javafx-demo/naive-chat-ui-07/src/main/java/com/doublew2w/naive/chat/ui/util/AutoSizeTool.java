package com.doublew2w.naive.chat.ui.util;

/**
 * @author: DoubleW2w
 * @description: 自动调整大小工具类
 * @date: 2024/4/13 0:02
 * @project: IM-Netty-NaiveChat
 */
public class AutoSizeTool {
  /**
   * 展示内容的宽度
   *
   * @param msg 消息体
   * @return 结果
   */
  public static double getWidth(String msg) {
    int len = msg.length();
    double width = 0;
    for (int i = 0; i < len; i++) {
      if (isChinese(msg.charAt(i))) {
        width += 16;
      } else {
        width += 16;
      }
    }

    width += 22; // 补全前后空格

    if (width > 450) {
      return 450;
    }

    return width < 50 ? 50 : width;
  }

  /**
   * 展现内容的高度
   *
   * @param msg 消息
   * @return 结果
   */
  public static double getHeight(String msg) {
    int len = msg.length();
    double width = 0;
    for (int i = 0; i < len; i++) {
      if (isChinese(msg.charAt(i))) {
        width += 16;
      } else {
        width += 16;
      }
    }

    width += 22; // 补全前后空格

    double remainder = width % 450;
    int line = (int) (width / 450);

    if (remainder != 0) {
      line = line + 1;
    }

    double autoHeight = line * 24 + 10;

    return autoHeight < 30 ? 30 : autoHeight;
  }

  private static boolean isChinese(char c) {
    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
    return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
  }
}

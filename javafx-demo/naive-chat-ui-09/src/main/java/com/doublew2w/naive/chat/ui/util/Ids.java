package com.doublew2w.naive.chat.ui.util;

/**
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/12 21:26
 * @project: IM-Netty-NaiveChat
 */
public class Ids {
  /** 对话框元素，好友对话列表框元素 */
  public static class ElementTalkId {
    public static String createTalkPaneId(String id) {
      return "ElementTalkId_createTalkPaneId_" + id;
    }

    public static String analysisTalkPaneId(String id) {
      return id.split("_")[2];
    }

    /**
     * 创建对话聊天框id
     *
     * @param id 对话框id
     * @return id
     */
    public static String createInfoBoxListId(String id) {
      return "ElementTalkId_createInfoBoxListId_" + id;
    }

    public static String analysisInfoBoxListId(String id) {
      return id.split("_")[2];
    }

    /**
     * 创建对话框——消息数据id
     *
     * @param id 对话框id
     * @return id
     */
    public static String createMsgDataId(String id) {
      return "ElementTalkId_createMsgDataId_" + id;
    }

    public static String analysisMsgDataId(String id) {
      return id.split("_")[2];
    }

    /**
     * 创建对话栏——消息概要Id
     *
     * @param id 对话框Id
     * @return id
     */
    public static String createMsgSketchId(String id) {
      return "ElementTalkId_createMsgSketchId_" + id;
    }

    public static String analysisMsgSketchId(String id) {
      return id.split("_")[2];
    }

    /**
     * 创建对话消息框——群聊id
     *
     * @param id 对话框id
     * @return id
     */
    public static String createFriendGroupId(String id) {
      return "ElementTalkId_createFriendGroupId_" + id;
    }
  }
}

package com.doublew2w.naive.chat.ui.view.chat;

import java.util.Date;

/**
 * 聊天窗口打开
 *
 * @author: DoubleW2w
 * @description:
 * @date: 2024/4/10 23:43
 * @project: IM-Netty-NaiveChat
 */
public interface IChatMethod {

  /** 打开窗口 */
  void doShow();

  /**
   * 设置登陆用户头像
   *
   * @param userId       用户ID
   * @param userNickName 用户昵称
   * @param userHead     头像图片名称
   */
  void setUserInfo(String userId, String userNickName, String userHead);

  /**
   * 填充对话框列表
   *
   * @param talkIdx 对话框位置；首位0、默认-1
   * @param talkType 对话框类型；好友0、群组1
   * @param talkId 对话框ID，1v1聊天ID、1vn聊天ID
   * @param talkName 对话框名称
   * @param talkHead 对话框头像
   * @param talkSketch 对话框通信简述(聊天内容最后一组信息)
   * @param talkDate 对话框通信时间
   * @param selected 选中[true/false]
   */
  void addTalkBox(
      int talkIdx,
      Integer talkType,
      String talkId,
      String talkName,
      String talkHead,
      String talkSketch,
      Date talkDate,
      Boolean selected);

  /**
   * 填充对话框消息-好友[别人的消息]
   *
   * @param talkId 对话框ID[用户ID]
   * @param msg 消息
   * @param msgData 时间
   * @param idxFirst 是否设置首位
   * @param selected 是否选中
   * @param isRemind 是否提醒
   */
  void addTalkMsgUserLeft(
      String talkId,
      String msg,
      Date msgData,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind);

  /**
   * 填充对话框消息-群组[别人的消息]
   *
   * @param talkId 对话框ID[群组ID]
   * @param userId 用户ID[群员]
   * @param userNickName 用户昵称
   * @param userHead 用户头像
   * @param msg 消息
   * @param msgDate 时间
   * @param idxFirst 是否设置首位
   * @param selected 是否选中
   * @param isRemind 是否提醒
   */
  void addTalkMsgGroupLeft(
      String talkId,
      String userId,
      String userNickName,
      String userHead,
      String msg,
      Date msgDate,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind);

  /**
   * 填充对话框消息[自己的消息]
   *
   * @param talkId 对话框ID[用户ID]
   * @param msg 消息
   * @param msgData 时间
   * @param idxFirst 是否设置首位
   * @param selected 是否选中
   * @param isRemind 是否提醒
   */
  void addTalkMsgRight(
      String talkId,
      String msg,
      Date msgData,
      Boolean idxFirst,
      Boolean selected,
      Boolean isRemind);
}

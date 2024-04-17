package com.doublew2w.naive.chat.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class TalkBox {

    private Long id;          // 自增ID
    private String userId;    // 用户ID
    private String talkId;    // 对话框ID(好友ID、群组ID)
    private Integer talkType; // 对话框类型；0好友、1群组
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

}

package com.doublew2w.naive.chat.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 群组
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class Groups {

    private Long id;          // 自增ID
    private String groupId;   // 群组ID
    private String groupName; // 群组名称
    private String groupHead; // 群组头像
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间


}

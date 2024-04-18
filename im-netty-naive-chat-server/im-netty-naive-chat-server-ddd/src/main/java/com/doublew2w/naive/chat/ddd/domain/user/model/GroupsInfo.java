package com.doublew2w.naive.chat.ddd.domain.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 14:12
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class GroupsInfo {
    private String groupId;     // 群组ID
    private String groupName;   // 群组名称
    private String groupHead;   // 群组头像
}

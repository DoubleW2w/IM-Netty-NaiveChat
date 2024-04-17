package com.doublew2w.naive.chat.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户好友
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class UserFriend {

    private Long id;             // 自增ID
    private String userId;       // 用户ID
    private String userFriendId; // 好友用户ID
    private Date createTime;     // 创建时间
    private Date updateTime;     // 更新时间

    public UserFriend() {
    }

    public UserFriend(String userId, String userFriendId) {
        this.userId = userId;
        this.userFriendId = userFriendId;
    }

}

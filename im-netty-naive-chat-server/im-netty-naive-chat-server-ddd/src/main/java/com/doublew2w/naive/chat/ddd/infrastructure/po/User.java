package com.doublew2w.naive.chat.ddd.infrastructure.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 * @author: DoubleW2w
 * @date: 2024/4/17 9:25
 * @project: IM-Netty-NaiveChat
 */
@Setter
@Getter
public class User {

    private Long id;             //自增ID
    private String userId;       //用户ID
    private String userNickName; //用户昵称
    private String userHead;     //用户头像
    private String userPassword; //用户密码
    private Date createTime;     //创建时间
    private Date updateTime;     //更新时间


}

CREATE DATABASE `itstack`;

DROP TABLE IF EXISTS `itstack`.`chat_record`;
CREATE TABLE `itstack`.`chat_record` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                         `userId` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '自己ID',
                                         `friendId` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '好友ID',
                                         `msgContent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '消息内容',
                                         `msgDate` datetime DEFAULT NULL COMMENT '消息时间',
                                         `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                         `talkType` int(11) DEFAULT NULL COMMENT '对话框类型：0好友、1群组',
                                         `msgType` int(11) DEFAULT '0' COMMENT '消息类型',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (3, '523088136', '184172133', '小傅哥，中午好哦。周末你在家干啥呢', '2020-02-23 11:33:37', '2020-02-23 11:33:37', '2020-02-23 11:33:37', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (4, '523088136', '184172133', '怎么不说话？', '2020-02-23 11:33:49', '2020-02-23 11:33:49', '2020-02-23 11:33:49', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (5, '184172133', '523088136', '做饭呢，做饭呢。', '2020-02-23 11:33:58', '2020-02-23 11:33:58', '2020-02-23 11:33:58', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (6, '184172133', '523088136', '可香了，要不要来吃饭。吃完在学习。https://bugstack.cn', '2020-02-23 11:34:24', '2020-02-23 11:34:24', '2020-02-23 11:34:24', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (7, '523088136', '184172133', '咿呀！又推荐你的博客了！', '2020-02-23 11:34:35', '2020-02-23 11:34:35', '2020-02-23 11:34:35', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (8, '523088136', '184172133', '走了走了！', '2020-02-23 11:34:38', '2020-02-23 11:34:38', '2020-02-23 11:34:38', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (9, '184172133', '523088136', '!!咋了就知道吃，不学习呀！', '2020-02-23 11:34:56', '2020-02-23 11:34:56', '2020-02-23 11:34:56', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (10, '523088136', '5307397', '嗨，小伙伴们，你们都在干啥呢？', '2020-02-23 15:26:32', '2020-02-23 15:26:32', '2020-02-23 15:26:32', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (11, '184172133', '5307397', '我在家呢，今天周末了。自己做点好吃的。', '2020-02-23 15:26:49', '2020-02-23 15:26:49', '2020-02-23 15:26:49', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (12, '796542178', '5307397', '哈哈哈，我也在。我想吃肉', '2020-02-23 15:27:00', '2020-02-23 15:27:00', '2020-02-23 15:27:00', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (13, '523088136', '5307397', '你太胖了，你吃点罗布吧', '2020-02-23 15:27:10', '2020-02-23 15:27:10', '2020-02-23 15:27:10', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (14, '523088136', '5307397', '萝卜', '2020-02-23 15:27:15', '2020-02-23 15:27:15', '2020-02-23 15:27:15', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (15, '184172133', '5307397', '萝卜妹妹', '2020-02-23 18:54:08', '2020-02-23 18:54:08', '2020-02-23 18:54:08', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (16, '184172133', '5307397', '我要测试断线重连了', '2020-02-23 18:54:17', '2020-02-23 18:54:17', '2020-02-23 18:54:17', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (17, '184172133', '5307397', '主动断开服务端，等待恢复', '2020-02-23 18:54:24', '2020-02-23 18:54:24', '2020-02-23 18:54:24', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (18, '523088136', '5307397', '纳尼！？好的！', '2020-02-23 18:54:30', '2020-02-23 18:54:30', '2020-02-23 18:54:30', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (19, '184172133', '5307397', '恢复了，可以通信了', '2020-02-23 18:55:16', '2020-02-23 18:55:16', '2020-02-23 18:55:16', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (20, '523088136', '5307397', '哇！', '2020-02-23 18:55:19', '2020-02-23 18:55:19', '2020-02-23 18:55:19', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (21, '523088136', '5307397', '666', '2020-02-23 18:55:21', '2020-02-23 18:55:21', '2020-02-23 18:55:21', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (37, '184172133', '523088136', '兔兔，我们可以发送表情了哦', '2020-02-23 14:17:41', '2020-02-23 14:17:41', '2020-02-23 14:17:41', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (38, '184172133', '523088136', 'f_22', '2020-02-23 14:17:45', '2020-02-23 14:17:45', '2020-02-23 14:17:45', 0, 1);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (39, '523088136', '184172133', '哇，真的哦！太好了！', '2020-02-23 14:17:59', '2020-02-23 14:17:59', '2020-02-23 14:17:59', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (40, '523088136', '184172133', 'f_24', '2020-02-23 14:18:03', '2020-02-23 14:18:03', '2020-02-23 14:18:03', 0, 1);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (41, '523088136', '184172133', 'f_05', '2020-02-23 14:18:09', '2020-02-23 14:18:09', '2020-02-23 14:18:09', 0, 1);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (42, '523088136', '184172133', 'f_15', '2020-02-23 14:18:12', '2020-02-23 14:18:12', '2020-02-23 14:18:12', 0, 1);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (43, '523088136', '184172133', 'f_12', '2020-02-23 14:18:14', '2020-02-23 14:18:14', '2020-02-23 14:18:14', 0, 1);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (44, '523088136', '184172133', 'f_25', '2020-02-23 14:18:17', '2020-02-23 14:18:17', '2020-02-23 14:18:17', 0, 1);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (45, '184172133', '5307397', '叮咚咚', '2020-02-23 14:20:51', '2020-02-23 14:20:51', '2020-02-23 14:20:51', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (46, '523088136', '184172133', '的', '2020-02-23 14:21:39', '2020-02-23 14:21:39', '2020-02-23 14:21:39', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (47, '184172133', '523088136', '哈哈哈', '2020-02-23 14:38:02', '2020-02-23 14:38:02', '2020-02-23 14:38:02', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (48, '184172133', '523088136', '在吗', '2020-02-23 14:38:06', '2020-02-23 14:38:06', '2020-02-23 14:38:06', 0, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (49, '523088136', '5307397', '有人吗', '2020-02-23 14:38:11', '2020-02-23 14:38:12', '2020-02-23 14:38:12', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (50, '184172133', '5307397', '有人有人', '2020-02-23 14:38:19', '2020-02-23 14:38:19', '2020-02-23 14:38:19', 1, 0);
insert into `itstack`.`chat_record` (id, userId, friendId, msgContent, msgDate, createTime, updateTime, talkType, msgType) values (51, '523088136', '184172133', '这回就对了', '2020-02-23 14:38:29', '2020-02-23 14:38:29', '2020-02-23 14:38:29', 0, 0);


DROP TABLE IF EXISTS `itstack`.`talk_box`;
CREATE TABLE `itstack`.`talk_box` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                      `userId` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户ID',
                                      `talkId` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '对话框ID(好友ID、群组ID)',
                                      `talkType` int DEFAULT NULL COMMENT '对话框类型：0好友、1群组',
                                      `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`id`),
                                      UNIQUE KEY `uni_talkId_userId` (`talkId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into `itstack`.`talk_box` (id, userId, talkId, talkType, createTime, updateTime) values (1, '184172133', '5307397', 1, '2020-02-23 19:35:54', '2020-02-23 19:35:54');
insert into `itstack`.`talk_box` (id, userId, talkId, talkType, createTime, updateTime) values (2, '523088136', '5307397', 1, '2020-02-23 19:36:00', '2020-02-23 19:36:00');
insert into `itstack`.`talk_box` (id, userId, talkId, talkType, createTime, updateTime) values (3, '184172133', '523088136', 0, '2020-02-23 19:36:03', '2020-02-23 19:36:03');
insert into `itstack`.`talk_box` (id, userId, talkId, talkType, createTime, updateTime) values (4, '523088136', '184172133', 0, '2020-02-23 19:36:03', '2020-02-23 19:36:03');
insert into `itstack`.`talk_box` (id, userId, talkId, talkType, createTime, updateTime) values (5, '796542178', '5307397', 1, '2020-02-23 15:26:32', '2020-02-23 15:26:32');


DROP TABLE IF EXISTS `itstack`.`user`;
CREATE TABLE `itstack`.`user` (
                                  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                  `userId` VARCHAR (9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户ID',
                                  `userNickName` VARCHAR (32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
                                  `userHead` VARCHAR (16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',
                                  `userPassword` VARCHAR (64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户密码',
                                  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (1, '184172133', '小傅哥', '01_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (2, '980765512', '铁锤', '02_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (3, '796542178', '团团', '03_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (4, '523088136', '哈尼克兔', '04_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (5, '123456001', '比丘卡', '05_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (6, '123456002', '兰兰', '06_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (7, '123456003', 'Alexa', '07_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (8, '123456004', '小白', '08_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (9, '123456005', '铃铛', '09_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (10, '123456006', '马小帅', '10_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (11, '123456007', 'S.A.K', '11_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user` (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (12, '123456008', '池鱼有点贤', '12_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');




DROP TABLE IF EXISTS `itstack`.`groups`;
CREATE TABLE `itstack`.`groups` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                    `groupId` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '群组ID',
                                    `groupName` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '群组名称',
                                    `groupHead` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '群组头像',
                                    `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `uni_groupId` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into `itstack`.`groups` (id, groupId, groupName, groupHead, createTime, updateTime) values (1, '5307397', '虫洞技术栈(1024)', 'group_1', '2020-01-01 00:00:00', '2020-01-01 00:00:00');


DROP TABLE IF EXISTS `itstack`.`user_friend`;
CREATE TABLE `itstack`.`user_friend` (
                                         id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                         userId BIGINT(20) COMMENT '用户ID',
                                         userFriendId BIGINT(20) COMMENT '好友用户ID',
                                         `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                         PRIMARY KEY ( id ),
                                         UNIQUE KEY uni_userId_userFriendId ( `userId`, `userFriendId` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into `itstack`.`user_friend` (id, userId, userFriendId, createTime, updateTime) values (27, 523088136, 184172133, '2020-02-23 13:02:45', '2020-02-23 13:02:45');
insert into `itstack`.`user_friend` (id, userId, userFriendId, createTime, updateTime) values (28, 184172133, 523088136, '2020-02-23 13:02:45', '2020-02-23 13:02:45');
insert into `itstack`.`user_friend` (id, userId, userFriendId, createTime, updateTime) values (29, 184172133, 123456007, '2020-02-23 13:02:56', '2020-02-23 13:02:56');
insert into `itstack`.`user_friend` (id, userId, userFriendId, createTime, updateTime) values (30, 123456007, 184172133, '2020-02-23 13:02:56', '2020-02-23 13:02:56');


DROP TABLE IF EXISTS `itstack`.`user_group`;
CREATE TABLE `itstack`.`user_group` (
                                        `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                        `userId` VARCHAR (9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户ID',
                                        `groupId` VARCHAR (9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '群组ID',
                                        `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                        PRIMARY KEY (`id`),
                                        UNIQUE uni_userId_groupId ( `userId`, `groupId` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (1, '184172133', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (11, '980765512', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (12, '796542178', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (13, '523088136', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (14, '123456001', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (15, '123456002', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (16, '123456003', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (17, '123456004', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (18, '123456005', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (19, '123456006', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (20, '123456007', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into `itstack`.`user_group` (id, userId, groupId, createTime, updateTime) values (21, '123456008', '5307397', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
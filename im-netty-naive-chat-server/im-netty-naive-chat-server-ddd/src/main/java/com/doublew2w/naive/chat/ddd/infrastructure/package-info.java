/**
 * infrastructure - 基础设施层，持久化，领域层对外依赖的接口实现
 *
 * <p>dao 持久化，每一个表的操作对应一个dao接口
 *
 * <p>po 持久化普通类，跟表的字段一一对应
 *
 * <p>repository 资源库的实现
 *
 * <p>util 工具包
 *
 * <p>common 常量包、字典类包
 *
 * <p></p>
 *
 * <p>DDD: infrastructure 基础实施层 最底层(但与所有层进行交互)
 *
 * <p>向其他层提供 通用的 技术能力(比如工具类,第三方库类支持,常用基本配置,数据访问底层实现)
 *
 * <p>基础实施层主要包含以下的内容:
 *
 * <p>为应用层 传递消息(比如通知)
 *
 * <p>为领域层 提供持久化机制(最底层的实现)
 *
 * <p>为用户界面层 提供组件配置
 *
 * <p>基础设施层还能够通过架构框架来支持四个层次间的交互模式。
 *
 * @author: DoubleW2w
 * @date: 2024/4/17 12:38
 * @project: IM-Netty-NaiveChat
 */
package com.doublew2w.naive.chat.ddd.infrastructure;

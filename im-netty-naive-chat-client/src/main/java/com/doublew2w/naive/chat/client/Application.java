package com.doublew2w.naive.chat.client;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.setting.Setting;
import com.doublew2w.naive.chat.client.application.UIService;
import com.doublew2w.naive.chat.client.event.ChatEvent;
import com.doublew2w.naive.chat.client.event.LoginEvent;
import com.doublew2w.naive.chat.client.infrastructure.util.CacheUtil;
import com.doublew2w.naive.chat.client.socket.NettyClient;
import com.doublew2w.naive.chat.protocol.login.ReconnectRequest;
import com.doublew2w.naive.chat.ui.view.chat.ChatController;
import com.doublew2w.naive.chat.ui.view.chat.IChatMethod;
import com.doublew2w.naive.chat.ui.view.login.ILoginMethod;
import com.doublew2w.naive.chat.ui.view.login.LoginController;
import io.netty.channel.Channel;
import java.util.concurrent.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 19:30
 * @project: IM-Netty-NaiveChat
 */
public class Application extends javafx.application.Application {

  private final Logger logger = LoggerFactory.getLogger(Application.class);
  private final ExecutorService executorService = ThreadUtil.newFixedExecutor(2, "client", true);
  private final ScheduledExecutorService scheduledExecutorService =
      ThreadUtil.createScheduledExecutor(1);
  private final Setting setting = new Setting("application.setting");

  @Override
  public void start(Stage primaryStage) throws Exception {
    // 1. 启动窗口
    IChatMethod chat = new ChatController(new ChatEvent());
    ILoginMethod login = new LoginController(new LoginEvent(), chat);
    login.doShow();

    UIService uiService = new UIService();
    uiService.setChat(chat);
    uiService.setLogin(login);

    // 2. 启动socket连接
    logger.info(
        "NettyClient连接服务开始 inetHost：{} inetPort：{}", setting.get("host"), setting.get("port"));
    NettyClient nettyClient = new NettyClient(uiService);
    Future<Channel> future = executorService.submit(nettyClient);
    Channel channel = future.get();
    if (null == channel) {
      throw new RuntimeException("netty client start error channel is null");
    }

    while (!nettyClient.isActive()) {
      logger.info("NettyClient启动服务 ...");
      Thread.sleep(500);
    }
    logger.info("NettyClient连接服务完成 {}", channel.localAddress());

    // Channel状态定时巡检；3秒后每5秒执行一次
    scheduledExecutorService.scheduleAtFixedRate(
        () -> {
          while (!nettyClient.isActive()) {
            System.out.println("通信管道巡检：通信管道状态 " + nettyClient.isActive());
            try {
              System.out.println("通信管道巡检：断线重连[Begin]");
              Channel freshChannel = executorService.submit(nettyClient).get();
              if (null == CacheUtil.userId) continue;
              freshChannel.writeAndFlush(new ReconnectRequest(CacheUtil.userId));
            } catch (InterruptedException | ExecutionException e) {
              System.out.println("通信管道巡检：断线重连[Error]");
            }
          }
        },
        3,
        5,
        TimeUnit.SECONDS);
  }

  public static void main(String[] args) {
    launch(args);
  }
}

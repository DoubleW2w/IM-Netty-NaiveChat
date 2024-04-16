package com.doublew2w.naive.chat;

import com.doublew2w.naive.chat.socket.NettyServer;
import io.netty.channel.Channel;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: DoubleW2w
 * @date: 2024/4/17 0:27
 * @project: IM-Netty-NaiveChat
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(Application.class);

  @Resource private NettyServer nettyServer;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("NettyServer启动服务开始 port：7397");
    Future<Channel> future = Executors.newFixedThreadPool(2).submit(nettyServer);
    Channel channel = future.get();
    if (null == channel) throw new RuntimeException("netty server start error channel is null");

    while (!channel.isActive()) {
      logger.info("NettyServer启动服务 ...");
      Thread.sleep(500);
    }

    logger.info("NettyServer启动服务完成 {}", channel.localAddress());
  }
}

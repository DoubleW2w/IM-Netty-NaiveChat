package com.doublew2w.naive.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author: DoubleW2w
 * @date: 2024/4/14 19:42
 * @project: IM-Netty-NaiveChat
 */
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(Application.class);

  @Override
  public void run(String... args) throws Exception {
    logger.info("启动Netty服务");
  }
}

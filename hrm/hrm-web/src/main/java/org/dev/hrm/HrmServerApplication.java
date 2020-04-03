package org.dev.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author 冷嘉贤
 */
@SpringBootApplication
@EnableCaching
public class HrmServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(HrmServerApplication.class, args);
  }

}

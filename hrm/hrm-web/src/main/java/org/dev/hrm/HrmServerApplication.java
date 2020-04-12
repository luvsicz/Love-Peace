package org.dev.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

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

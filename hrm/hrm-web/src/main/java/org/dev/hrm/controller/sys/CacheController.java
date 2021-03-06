package org.dev.hrm.controller.sys;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.RespBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName CacheController.java
 * @createTime 2020年03月27日 16:16:00
 */
@RestController
@RequestMapping("/sys/cache")
public class CacheController {

  /**
   * 清除Redis指定name的缓存
   */
  @CacheEvict(value = "menuService")
  @GetMapping("/menuWithRole")
  @WebLogger
  public RespBean evictMenuCache() {
    return RespBean.ok("清理menuService缓存完成！");
  }

  /**
   * 清除Redis所有缓存
   */
  @CacheEvict(value = "menuService", allEntries = true)
  @GetMapping("/all")
  @WebLogger
  public RespBean evictAll() {
    return RespBean.ok("清理所有缓存完成！");

  }

}

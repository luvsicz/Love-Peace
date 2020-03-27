package org.dev.hrm.controller.sys;

import org.dev.hrm.model.RespBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName CacheController.java
 * @Description TODO
 * @createTime 2020年03月27日 16:16:00
 */
@RestController
@RequestMapping("/system/evictCache")
public class CacheController {

  /**
   * 清楚Redis指定name的缓存
   */
  @CacheEvict(value = "menuService")
  @RequestMapping("/menuWithRole")
  public RespBean evictMenuCache() {
    return RespBean.ok("清理menuService缓存完成！");
  }

  /**
   * 清楚Redis所有缓存
   */
  @CacheEvict(value = "menuService", allEntries = true)
  @RequestMapping("/all")
  public RespBean evictAll() {
    return RespBean.ok("清理所有缓存完成！");

  }

}

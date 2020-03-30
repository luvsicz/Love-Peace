package org.dev.hrm.controller.config;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Menu;
import org.dev.hrm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 冷嘉贤
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

  @Autowired
  MenuService menuService;

  @GetMapping("/menu")
  @WebLogger
  public List<Menu> getMenusByHrId() {
    return menuService.getMenusByHrId();

  }
}
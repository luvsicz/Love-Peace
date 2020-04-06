package org.dev.hrm.controller.config;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Menu;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.MenuService;
import org.dev.hrm.service.MsgContentService;
import org.dev.hrm.service.SysmsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 冷嘉贤
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

  @Autowired
  MenuService menuService;
  @Autowired
  SysmsgService sysmsgService;
  @Autowired
  MsgContentService msgContentService;

  /**
   * 获取当前用户的通知列表
   *
   * @param page
   * @param size
   * @return
   */
  @GetMapping("/notice")
  @WebLogger
  public RespBean getNotices(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size) {
    return RespBean.ok("",
        sysmsgService.getMyNotices(page, size));
  }

  /**
   * 更新通知状态为已读
   *
   * @param ids
   * @return
   */
  @PutMapping("/notice/{ids}")
  @WebLogger
  public RespBean updateNotificationsState(@PathVariable String ids) {
    sysmsgService.updateByPrimaryKeysSelective(ids);
    return RespBean.ok("");
  }

  @GetMapping("/menu")
  @WebLogger
  public List<Menu> getMenusByHrId() {
    return menuService.getMenusByHrId();

  }
}
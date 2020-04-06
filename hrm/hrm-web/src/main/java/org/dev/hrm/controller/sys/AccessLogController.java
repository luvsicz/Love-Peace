package org.dev.hrm.controller.sys;

import java.util.Date;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.AccessLog;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName AccessLogController.java
 * @createTime 2020年03月30日 21:52:00
 */
@RestController
@RequestMapping("/sys/access")
public class AccessLogController {

  @Autowired
  AccessLogService service;

  @GetMapping("/")
  public RespBean getAccessLogByPage(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, AccessLog accessLog,
      Date[] beginDateScope) {
    return RespBean.ok("",
        service.getAccessLogByPage(page, size, accessLog, beginDateScope));
  }

  @DeleteMapping
  @WebLogger
  public RespBean deleteAccessLog() {
    return RespBean.ok("清理AccessLog成功", service.truncateAll());
  }
}

package org.dev.hrm.controller.sys;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Oplog;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.OplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrLogController.java
 * @createTime 2020年04月06日 14:42:00
 */
@RestController
@RequestMapping("/sys/log")
public class HrLogController {

  @Autowired
  OplogService oplogService;

  @GetMapping("/")
  @WebLogger
  public RespBean getOpLogByPage(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Oplog oplog) {
    return RespBean.ok("",
        oplogService.getOpLogByPage(page, size, oplog));
  }

  @DeleteMapping("/")
  @WebLogger
  public RespBean deleteOpLoG() {
    return RespBean.ok("清理HRlog成功",
        oplogService.deleteAll());
  }
}

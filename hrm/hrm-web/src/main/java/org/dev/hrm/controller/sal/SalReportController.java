package org.dev.hrm.controller.sal;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年05月14日 12:56:00
 */
@RestController
@RequestMapping("/sal/report")
public class SalReportController {

  @Autowired
  DepartmentService departmentService;

  @GetMapping("/")
  @WebLogger
  public RespBean getDepSalReport() {
    return departmentService
        .getDepSalReport();
  }
}

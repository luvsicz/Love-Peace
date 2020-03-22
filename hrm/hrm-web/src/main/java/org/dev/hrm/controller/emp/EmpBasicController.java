package org.dev.hrm.controller.emp;

import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmpBasicController.java
 * @Description TODO
 * @createTime 2020年03月22日 17:35:00
 */
@RestController
@RequestMapping("/employee/")
public class EmpBasicController {

  @Autowired
  EmployeeService service;

  @GetMapping("basic")
  public RespBean getEmployeeInfo(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer count,
      @RequestParam(defaultValue = "") String keyword) {
    return service.getEmployeeByPage(page, count, keyword);
  }

}

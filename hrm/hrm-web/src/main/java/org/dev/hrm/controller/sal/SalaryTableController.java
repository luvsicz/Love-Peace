package org.dev.hrm.controller.sal;

import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SalaryTableController.java

 * @createTime 2020年03月29日 16:57:00
 */
@RestController
@RequestMapping("/sal/table")
public class SalaryTableController {

  @Autowired
  SalaryService salaryService;
  @Autowired
  EmployeeService employeeService;

  /**
   * 获取指定部门的员工的工资信息
   * @param page
   * @param size
   * @param depId
   * @return
   */
/*  @GetMapping("/")
  public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Integer depId) {
    return employeeService.getEmployeeByPageWithSalary(page, size,depId);
  }*/

}

package org.dev.hrm.controller.sal;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.RespPageBean;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.SalaryService;
import org.dev.hrm.util.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
   * 获取指定部门员工的工资表格信息
   *
   * @param page
   * @param size
   * @param depId
   * @return
   */
  @GetMapping("/")
  @WebLogger
  public RespPageBean getEmployeeByPageWithSalaryByDepId(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Integer depId) {
    return employeeService.getEmployeeByPageWithSalary(page, size, depId,null);
  }

  /**
   * 到处指定部门的工资表
   */
  @GetMapping("/export")
  @WebLogger
  public ResponseEntity<byte[]> exportData(@RequestParam Integer depId) {
    List<Employee> list = (List<Employee>) employeeService
        .getEmployeeByPageWithSalary(null, null, depId,null).getData();
    return POIUtils.depSalary2Excel(list);
  }
}
